package com.scaler.bookmyshow.models;

import lombok.Data;

import java.util.List;

@Data
public class Movie extends BaseModel{
    private List<Language> languages;
    private String title;
    private String year;
    private String genre;
}
