package com.crs.carrentalsystem.rental.service;

import com.crs.carrentalsystem.car.controller.assembler.CarAssembler;
import com.crs.carrentalsystem.car.controller.dto.CarDto;
import com.crs.carrentalsystem.car.controller.dto.CarSearchDto;
import com.crs.carrentalsystem.car.entity.Car;
import com.crs.carrentalsystem.car.repository.CarRepository;
import com.crs.carrentalsystem.car.repository.CarSpecification;
import com.crs.carrentalsystem.rental.controller.assembler.RentalAssembller;
import com.crs.carrentalsystem.rental.controller.dto.RentalDto;
import com.crs.carrentalsystem.rental.controller.dto.RentalSearchDto;
import com.crs.carrentalsystem.rental.entity.Rental;
import com.crs.carrentalsystem.rental.repository.RentalRepository;
import com.crs.carrentalsystem.rental.repository.RentalSpecification;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
@RequiredArgsConstructor
public class RentalServiceImpl implements RentalService{
    private final RentalRepository rentalRepository;
    private final RentalAssembller rentalAssembler;
    @Override
    public Rental create(RentalDto RentalDto) {
        Rental rental = new Rental();
            return Optional.of(rental)
                    .map(entity -> rentalAssembler.toRental(RentalDto,rental))
                    .map(rentalRepository::save)
                    .orElseThrow(() -> new RuntimeException("rental details was not saved successfully"));
        }
    @Override
    public Rental getById(Long id) {

            return Optional.of(id)
                    .flatMap(rentalRepository::findById)
                    .orElseThrow(() -> new RuntimeException("No rental with ID :" + id + "found"));
    }
    @Override
    public Rental Update(RentalDto rentalDto) {

            Rental rentedCar = rentalRepository.findById(rentalDto.getId())
                    .orElseThrow(() -> new EntityNotFoundException("rental details of id not found with ID: " + rentalDto.getId()));
            // Update the existing car entity with the values from the DTO
            rentalAssembler.toRental(rentalDto, rentedCar);

            // Save the updated car entity
            return rentalRepository.save(rentedCar);
        }
    @Override
    public void delete(long id) {
            getById(id);
            rentalRepository.deleteById(id);
        }
    @Override
    public Page<Rental> search(RentalSearchDto rentalSearchDto, Pageable pageable) {
            Specification<Rental> rentalspecification = RentalSpecification.getPredicate(rentalSearchDto);
            return rentalRepository.findAll(rentalspecification,pageable);
        }

    }

