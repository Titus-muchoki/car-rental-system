package com.crs.carrentalsystem.car.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.experimental.Accessors;
@Entity
@Data
@Accessors(chain = true)
@Table(name = "car-tb")
public class Car {
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
    private Integer seatingCapacity;
    private Double speed;
    private Type type;
}
