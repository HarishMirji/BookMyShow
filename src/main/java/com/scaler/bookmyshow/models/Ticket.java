package com.scaler.bookmyshow.models;

import lombok.Data;

import java.util.List;

@Data
public class Ticket extends BaseModel{
    private int amount;
    private Data timeOfBooking;
    private List<Seat> seats;
    private User bookedBy;
    private Show show;
    private List<Payment> payments;
    private TicketStatus status;
}
