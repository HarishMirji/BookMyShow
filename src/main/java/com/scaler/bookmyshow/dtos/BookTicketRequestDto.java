package com.scaler.bookmyshow.dtos;

import lombok.Data;

import java.util.List;

@Data
public class BookTicketRequestDto {
    private List<Long> seatIds;
    private Long userId;
    private Long showId;

}
