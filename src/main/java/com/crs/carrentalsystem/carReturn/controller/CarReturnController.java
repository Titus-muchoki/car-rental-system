package com.crs.carrentalsystem.carReturn.controller;

import com.crs.carrentalsystem.carReturn.controller.assembler.CarReturnAssembler;
import com.crs.carrentalsystem.carReturn.controller.dto.CarReturnDto;
import com.crs.carrentalsystem.carReturn.controller.dto.CarReturnSearchDto;
import com.crs.carrentalsystem.carReturn.entity.CarReturn;
import com.crs.carrentalsystem.carReturn.service.CarReturnService;
import com.crs.carrentalsystem.rental.controller.assembler.RentalAssembller;
import com.crs.carrentalsystem.rental.controller.dto.RentalDto;
import com.crs.carrentalsystem.rental.controller.dto.RentalSearchDto;
import com.crs.carrentalsystem.rental.entity.Rental;
import com.crs.carrentalsystem.rental.service.RentalService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/carReturn")
public class CarReturnController {
    private final CarReturnService carReturnService;
    private final CarReturnAssembler carReturnAssembler;
    @ResponseStatus(HttpStatus.OK)
    @PostMapping
    public CarReturnDto create(@RequestBody CarReturnDto carReturnDto){
        return carReturnAssembler.toCarReturnDto(carReturnService.create(carReturnDto));
    }
    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  CarReturnDto getById(@PathVariable long id) {

        return carReturnAssembler.toCarReturnDto(carReturnService.getById(id));
    }
    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public  CarReturnDto update(@PathVariable long id, @RequestBody  @Valid CarReturnDto request) {
        if (id != request.getId()) {
            throw new RuntimeException("Path ID does not match DTO value");
        }
        CarReturn carReturn = carReturnService.Update(request);
        return carReturnAssembler.toCarReturnDto(carReturn);

    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id) {

        carReturnService.delete(id);
    }
    @PostMapping ("/search")
    @ResponseStatus(HttpStatus.OK)
    public Page<CarReturnDto> search(@RequestBody CarReturnSearchDto carReturnSearchDto, Pageable pageable) {
        return carReturnService.search(carReturnSearchDto, pageable)
                .map(carReturnAssembler::toCarReturnDto);
    }
}
