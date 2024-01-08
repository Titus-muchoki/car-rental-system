package com.crs.carrentalsystem.car.controller.dto;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class CarSearchDto {
    private String search;
}
