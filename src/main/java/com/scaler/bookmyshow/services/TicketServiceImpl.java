package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.exceptions.InvalidArgumentException;
import com.scaler.bookmyshow.exceptions.SeatNotAvailableException;
import com.scaler.bookmyshow.models.*;
import com.scaler.bookmyshow.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class TicketServiceImpl implements TicketService{

    private SeatRepository seatRepository;
    private ShowSeatRepository showSeatRepository;
    private ShowRepository showRepository;
    private UserRepository userRepository;
    private TicketRepository ticketRepository;

    @Autowired
    public TicketServiceImpl(SeatRepository seatRepository,
                             ShowSeatRepository showSeatRepository,
                             ShowRepository showRepository,
                             UserRepository userRepository,
                             TicketRepository ticketRepository){
        this.seatRepository = seatRepository;
        this.showSeatRepository = showSeatRepository;
        this.showRepository = showRepository;
        this.userRepository = userRepository;
        this.ticketRepository = ticketRepository;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(List<Long> seatIds, Long showId, Long userId) throws Exception {
        // 1. for these seatIds get the corresponding showseats  getSeatsForIds(ids)
        // 2. Check the status of all the showseats  getShowSeatsForSeats(seats)
        // 2.a : every seat is available
        // 3.a : lock every seat( set the status to be locked)
        // 4.a : Create Ticket obj and return it
        // 2.b : some of the seats are not available
        // 3.b : throw an exception

        List<Seat> seats = seatRepository.findAllByIdIn(seatIds);

        Optional<Show> optionalShow = showRepository.findById(showId);

        if(optionalShow.isEmpty()){
            throw new InvalidArgumentException("Show by " + showId + " doesn't exist.");
        }

        List<ShowSeat> showSeats = showSeatRepository.findAllBySeatInShow(seats, optionalShow.get());

        for(ShowSeat showSeat : showSeats){
            if(!showSeat.getStatus().equals(ShowSeatStatus.AVAILABLE)){
                throw new SeatNotAvailableException("");
            }
        }

        for(ShowSeat showSeat : showSeats){
            showSeat.setStatus(ShowSeatStatus.LOCKED);
            showSeat.setLockedAt(new Date());
        }
        showSeatRepository.saveAll(showSeats);

        Optional<User> optionalUser = userRepository.findById(userId);

        if(optionalUser.isEmpty()){
            throw new InvalidArgumentException("User with "+ userId + " doesn't exist.");
        }


        Ticket ticket = new Ticket();
        ticket.setStatus(TicketStatus.PROCESSING);
        ticket.setBookedBy(optionalUser.get());
        ticket.setShow(optionalShow.get());
        ticket.setSeats(seats);
        ticket.setAmount(0);
        ticket.setTimeOfBooking(new Date());

        return ticketRepository.save(ticket);
    }
}
