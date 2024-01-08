package com.crs.carrentalsystem.car.service;

import com.crs.carrentalsystem.car.controller.assembler.CarAssembler;
import com.crs.carrentalsystem.car.controller.dto.CarDto;
import com.crs.carrentalsystem.car.controller.dto.CarSearchDto;
import com.crs.carrentalsystem.car.entity.Car;
import com.crs.carrentalsystem.car.repository.CarRepository;
import com.crs.carrentalsystem.car.repository.CarSpecification;
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
public class CarServiceImpl implements CarService{
    private final CarRepository carRepository;
    private final CarAssembler carAssembler;

    @Override
    @Transactional
    public Car createCar(CarDto carDto) {

        Car car = new Car();
       return Optional.of(car)
               .map(entity -> carAssembler.toCar(carDto,car))
               .map(carRepository::save)
               .orElseThrow(() -> new RuntimeException("Car was not saved successfully"));
    }
    @Override
    public Car getCarsById(Long id) {
        return Optional.of(id)
                .flatMap(carRepository::findById)
                .orElseThrow(() -> new RuntimeException("No Car with ID :" + id + "found"));
    }
    @Override
    public Car UpdateCars(CarDto carDto) {
        // Retrieve the existing car entity by ID
        Car existingCar = carRepository.findById(carDto.getId())
                .orElseThrow(() -> new EntityNotFoundException("Car not found with ID: " + carDto.getId()));

        // Update the existing car entity with the values from the DTO
        carAssembler.toCar(carDto, existingCar);

        // Save the updated car entity
        return carRepository.save(existingCar);
    }

    @Override
    public void deleteCars(long id) {
         getCarsById(id);
         carRepository.deleteById(id);
    }
    @Override
    public Page<Car> searchCars(CarSearchDto carSearchDto, Pageable pageable) {
        Specification<Car> carspecification = CarSpecification.getPredicate(carSearchDto);
        return carRepository.findAll(carspecification,pageable);
    }
}
