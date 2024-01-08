package com.crs.carrentalsystem.rental.entity;

import com.crs.carrentalsystem.car.entity.Car;
import com.crs.carrentalsystem.customer.entity.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.Instant;

@Entity
@Data
@Accessors(chain = true)
public class Rental {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private int rental_fee;
    private Instant issue_Date;
    private Instant Due_date;

}
