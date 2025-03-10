package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Data;

import java.util.List;

@Data
@Entity
public class City extends BaseModel {
    @OneToMany(mappedBy = "city")
    private List<Theatre> theatres;
    private String name;
}
