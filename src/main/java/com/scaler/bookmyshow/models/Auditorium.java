package com.scaler.bookmyshow.models;

import lombok.Data;

import java.util.List;

@Data
public class Auditorium extends BaseModel{
    private String name;
    private List<Seat> seats;
    private List<Featues> featues;
}
