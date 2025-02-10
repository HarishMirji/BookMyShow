package com.scaler.bookmyshow.models;

import lombok.Data;

import java.util.List;

@Data
public class City extends BaseModel {
    private List<Theatre> theatres;
    private String name;
}
