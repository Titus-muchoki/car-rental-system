package com.crs.carrentalsystem.car.controller.assembler;

import com.crs.carrentalsystem.car.controller.dto.CarDto;
import com.crs.carrentalsystem.car.entity.Car;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CarAssembler {
    public CarDto tocarDto(Car from){
        CarDto to = new CarDto()
                .setId(from.getId())
                .setAvailable(from.isAvailable())
                .setCarRegNo(from.getCarRegNo())
                .setMake(from.getMake())
                .setModel(from.getModel())
                .setColor(from.getColor())
                .setSeatingCapacity(from.getSeatingCapacity());
        return to;
    }
    public  Car toCar(CarDto from, Car to){
        to.setId(from.getId())
                .setAvailable(from.isAvailable())
                .setModel(from.getModel())
                .setCarRegNo(from.getCarRegNo())
                .setMake(from.getMake())
                .setColor(from.getColor())
                .setSpeed(from.getSpeed())
                .setSeatingCapacity(from.getSeatingCapacity());

        return to;

    }
}
