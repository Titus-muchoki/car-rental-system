package com.crs.carrentalsystem.carReturn.controller.dto;

import com.crs.carrentalsystem.car.controller.dto.CarDto;
import com.crs.carrentalsystem.customer.controller.dto.CustomerDto;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.experimental.Accessors;

import java.time.Instant;
@Data
@Accessors(chain = true)
public class CarReturnDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  long id;
    private CarDto car;
    private CustomerDto  customer;
    private Instant return_date;
    private String car_condtion;
    private int penalty_fee;
}
