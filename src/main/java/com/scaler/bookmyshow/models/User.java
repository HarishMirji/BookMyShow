package com.scaler.bookmyshow.models;

import jakarta.persistence.Entity;
import lombok.Data;

@Data
@Entity
public class User extends BaseModel{
    private int age;
    private String name;
    private String email;
    private String password;
    private String phoneNumber;
}
