package com.crs.carrentalsystem.rental.controller.dto;

import com.crs.carrentalsystem.car.entity.Car;
import com.crs.carrentalsystem.customer.entity.Customer;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.experimental.Accessors;
import java.time.Instant;
@Data
@Accessors(chain = true)

public class RentalDto {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private Car car;
    private Customer customer;
    private int rental_fee;
    private Instant issue_Date;
    private Instant Due_date;
}
