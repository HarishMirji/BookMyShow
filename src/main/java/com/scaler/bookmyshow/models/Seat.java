package com.scaler.bookmyshow.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;

@Data
@Entity(name = "seats")
public class Seat extends BaseModel{
    private String seatNumber;
    @Column(name = "rowz")
    private int row;
    @Column(name = "colz")
    private int col;
    @ManyToOne
    private SeatType seatType;
}
