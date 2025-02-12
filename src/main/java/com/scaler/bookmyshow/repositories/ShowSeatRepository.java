package com.scaler.bookmyshow.repositories;

import com.scaler.bookmyshow.models.Seat;
import com.scaler.bookmyshow.models.Show;
import com.scaler.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {

    List<ShowSeat> findAllBySeatInShow(List<Seat> seats, Show show);

    List<ShowSeat> saveAll(List<ShowSeat> showSeats);

}
