package com.crs.carrentalsystem.customer.controller.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigInteger;

@Data
@Accessors(chain = true)
public class CustomerDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "national_id")
    private long NationalId;
    @Column(name = "home_address")
    private String homeAddress;
    @Column(name = "phone_No")
    private String phoneNo;
    @Column(name = "email")
    private String email;
}
