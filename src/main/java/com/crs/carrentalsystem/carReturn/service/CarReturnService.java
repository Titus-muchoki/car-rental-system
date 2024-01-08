package com.crs.carrentalsystem.carReturn.service;

import com.crs.carrentalsystem.carReturn.controller.dto.CarReturnDto;
import com.crs.carrentalsystem.carReturn.controller.dto.CarReturnSearchDto;
import com.crs.carrentalsystem.carReturn.entity.CarReturn;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CarReturnService {
    CarReturn create(CarReturnDto carReturnDto);
    CarReturn getById(Long id);
    CarReturn Update(CarReturnDto carReturnlDto);
    void delete(long id);
    Page<CarReturn> search(CarReturnSearchDto carReturnSearchDto, Pageable pageable);
}
