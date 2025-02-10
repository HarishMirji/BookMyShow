package com.scaler.bookmyshow.models;

import lombok.Data;

import java.util.List;

@Data
public class Theatre extends BaseModel{
    private String name;
    private String address;
    private City city;
    private List<Auditorium> auditoriums;
}
