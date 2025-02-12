package com.scaler.bookmyshow.dtos;

import lombok.Data;

import java.util.List;

@Data
public class BookTicketResponseDto {
    private int amount;
    private Long ticketId;
    private List<String> seatNumber;
    private String auditoriumName;

}


//bookmyshow.com/pay/{ticketId}