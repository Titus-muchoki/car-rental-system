package com.crs.carrentalsystem.rental.service;
import com.crs.carrentalsystem.rental.controller.dto.RentalDto;
import com.crs.carrentalsystem.rental.controller.dto.RentalSearchDto;
import com.crs.carrentalsystem.rental.entity.Rental;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface RentalService {
    Rental create(RentalDto RentalDto);
    Rental getById(Long id);
    Rental Update(RentalDto rentalDto);
    void delete(long id);
    Page<Rental> search(RentalSearchDto rentalSearchDto, Pageable pageable);

}
