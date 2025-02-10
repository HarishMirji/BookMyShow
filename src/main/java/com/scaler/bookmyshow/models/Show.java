package com.scaler.bookmyshow.models;

import lombok.Data;

import java.util.Date;

@Data
public class Show extends BaseModel{
    private Auditorium auditorium;
    private Date startTime;
    private Date endTime;
    private Movie movie;
    private Language language;
}
