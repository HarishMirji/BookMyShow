package com.scaler.bookmyshow.services;

import com.scaler.bookmyshow.exceptions.InvalidArgumentException;
import com.scaler.bookmyshow.exceptions.SeatNotAvailableException;
import com.scaler.bookmyshow.models.Ticket;

import java.util.List;

public interface TicketService {

    public Ticket bookTicket(List<Long> seatIds, Long showId, Long userId) throws Exception;
}
