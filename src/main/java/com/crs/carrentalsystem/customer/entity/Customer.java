package com.crs.carrentalsystem.customer.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Accessors;

import java.math.BigInteger;

@Entity
@Data
@Accessors(chain = true)
@Table(name = "customer-tb")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotBlank(message = "firstName is required")
    @Column(name = "first_name")
    private String firstName;
    @NotBlank(message = "firstName is required")
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "national_id")
    @NotBlank(message = "national_id is required")
    private long NationalId;
    @Column(name = "home_address")
    private String homeAddress;
    @NotBlank(message = "email is required")
    @Email(message = "Invalid email format")
    private String email;
    @NotBlank(message = "phone number is required")
    @Pattern(regexp = "^[0-9]{10}$", message ="Invalid phone number format")
    private String phoneNo;
}
