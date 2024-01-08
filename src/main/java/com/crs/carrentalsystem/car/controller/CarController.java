package com.crs.carrentalsystem.car.controller;

import com.crs.carrentalsystem.car.controller.assembler.CarAssembler;
import com.crs.carrentalsystem.car.controller.dto.CarDto;
import com.crs.carrentalsystem.car.controller.dto.CarSearchDto;
import com.crs.carrentalsystem.car.entity.Car;
import com.crs.carrentalsystem.car.service.CarService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import java.util.Objects;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/cars")
public class CarController {
    private final CarService carService;
    private final CarAssembler carAssembler;
    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public CarDto createCars(@RequestBody CarDto carDto){
        return carAssembler.tocarDto(carService.createCar(carDto));

    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarDto getById(@PathVariable long id) {
        return carAssembler.tocarDto(carService.getCarsById(id));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public CarDto update(@PathVariable long id, @RequestBody  @Valid CarDto request) {
        if (id != request.getId()) {
            throw new RuntimeException("Path ID does not match DTO value");
        }
        Car updatedCar = carService.UpdateCars(request);
        return carAssembler.tocarDto(updatedCar);

    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) {
        carService.deleteCars(id);

}
    @PostMapping ("/search")
    @ResponseStatus(HttpStatus.OK)
    public Page<CarDto> search(@RequestBody CarSearchDto carSearchDto, Pageable pageable) {
        return carService.searchCars(carSearchDto, pageable)
                .map(carAssembler::tocarDto);
    }
}
