package com.scaler.bookmyshow.controllers;

import com.scaler.bookmyshow.dtos.BookTicketRequestDto;
import com.scaler.bookmyshow.dtos.BookTicketResponseDto;
import com.scaler.bookmyshow.models.Ticket;
import com.scaler.bookmyshow.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
public class TicketController {

    private TicketService ticketService;

    @Autowired
    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public BookTicketResponseDto bookTicket(@RequestBody BookTicketRequestDto requestDto) throws Exception {
        Ticket ticket = ticketService.bookTicket(requestDto.getSeatIds(), requestDto.getShowId(), requestDto.getUserId());
        BookTicketResponseDto responseDto = new BookTicketResponseDto();
        responseDto.setTicketId(ticket.getId());
        responseDto.setAmount(ticket.getAmount());
        responseDto.setSeatNumber(Collections.singletonList(ticket.getSeats().toString()));
        responseDto.setAuditoriumName(ticket.getShow().getAuditorium().getName());

        return responseDto;
    }
}
