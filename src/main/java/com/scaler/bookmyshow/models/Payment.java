package com.scaler.bookmyshow.models;

import lombok.Data;

import java.util.Date;

@Data
public class Payment extends BaseModel{
    private int amount;
    private PaymentProvider paymentProvider;
    private Date time;
    private String refId;
    private PaymentStatus paymentStatus;
    private PaymentType paymentType;
}
