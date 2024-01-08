package com.crs.carrentalsystem.rental.controller.assembler;

import com.crs.carrentalsystem.rental.controller.dto.RentalDto;
import com.crs.carrentalsystem.rental.entity.Rental;
import org.springframework.stereotype.Component;

@Component
public class RentalAssembller {
    public RentalDto torentalDto(Rental from) {
        RentalDto to = new RentalDto();
        to.setId(from.getId())
                .setRental_fee(from.getRental_fee())
                .setIssue_Date(from.getIssue_Date())
                .setDue_date(from.getDue_date());
        if (from.getCar() != null) {
            to.setId(from.getCar().getId());
        }
        if ((from.getCustomer() != null)) {
            to.setId(from.getCustomer().getId());

        }
        return to;
    }

    public Rental toRental(RentalDto from, Rental to) {
        to.setId(from.getId())
                .setRental_fee(from.getRental_fee())
                .setIssue_Date(from.getIssue_Date())
                .setDue_date(from.getDue_date());
        if ((from.getCar() != null)) {
            to.setId(from.getCar().getId());
        }
        if (from.getCustomer() != null) {
            to.setId(from.getCustomer().getId());

        }
        return to;
    }
}




