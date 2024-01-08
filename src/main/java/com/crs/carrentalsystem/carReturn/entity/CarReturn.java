package com.crs.carrentalsystem.carReturn.entity;

import com.crs.carrentalsystem.car.entity.Car;
import com.crs.carrentalsystem.customer.entity.Customer;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.Instant;

@Entity
@Data
@Accessors(chain = true)
@Table(name = "carReturn-tb")
public class CarReturn {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    @ManyToOne
    @JoinColumn(name = "car_id")
    private Car car;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
    private Instant return_date;
    private String car_condtion;
    private int penalty_fee;

}
