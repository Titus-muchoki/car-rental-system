package com.crs.carrentalsystem.car.service;

import com.crs.carrentalsystem.car.controller.dto.CarDto;
import com.crs.carrentalsystem.car.controller.dto.CarSearchDto;
import com.crs.carrentalsystem.car.entity.Car;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarService {

    Car createCar(CarDto carDto);
    Car getCarsById(Long id);
    Car UpdateCars(CarDto carDto);
    void deleteCars(long id);
    Page<Car> searchCars(CarSearchDto carSearchDto, Pageable pageable);
}
