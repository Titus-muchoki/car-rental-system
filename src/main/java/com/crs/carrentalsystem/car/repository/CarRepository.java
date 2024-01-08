package com.crs.carrentalsystem.car.repository;

import com.crs.carrentalsystem.car.controller.dto.CarDto;
import com.crs.carrentalsystem.car.entity.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car,Long>, JpaSpecificationExecutor<Car> {
    Optional<CarDto> findByCarRegNo(String carRegNo);
}
