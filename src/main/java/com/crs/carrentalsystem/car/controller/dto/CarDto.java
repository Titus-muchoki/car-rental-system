package com.crs.carrentalsystem.car.controller.dto;

import com.crs.carrentalsystem.car.entity.Type;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CarDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "model")
    private String model;
    @Column(name = "make")
    private String make;
    @Column(name = "car_reg_No")
    private String carRegNo;
    @Column(name = "available")
    private boolean available;
    private String color;
    private Double speed;
    private Integer seatingCapacity;
    private Type type;

}
