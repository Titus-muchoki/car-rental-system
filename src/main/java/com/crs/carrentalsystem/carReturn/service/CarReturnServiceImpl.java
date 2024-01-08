package com.crs.carrentalsystem.carReturn.service;

import com.crs.carrentalsystem.carReturn.controller.assembler.CarReturnAssembler;
import com.crs.carrentalsystem.carReturn.controller.dto.CarReturnDto;
import com.crs.carrentalsystem.carReturn.controller.dto.CarReturnSearchDto;
import com.crs.carrentalsystem.carReturn.entity.CarReturn;
import com.crs.carrentalsystem.carReturn.repository.CarReturnRepository;
import com.crs.carrentalsystem.carReturn.repository.CarReturnSpecification;
import com.crs.carrentalsystem.customer.entity.Customer;
import com.crs.carrentalsystem.rental.entity.Rental;
import com.crs.carrentalsystem.rental.repository.RentalSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarReturnServiceImpl implements CarReturnService{
    private final CarReturnRepository carReturnRepository;
    private final CarReturnAssembler carReturnAssembler;
    @Override
    public CarReturn create(CarReturnDto carReturnDto) {
        CarReturn  carReturn = new CarReturn();
        return Optional.of(carReturn)
                .map(entity -> carReturnAssembler.toCarReturn(carReturnDto))
                .map(carReturnRepository::save)
                .orElseThrow(() -> new RuntimeException("carReturn details was not saved successfully"));
    }
    @Override
    public CarReturn getById(Long id) {
        return Optional.of(id)
                .flatMap(carReturnRepository::findById)
                .orElseThrow(() -> new RuntimeException("No CarReturn with ID :" + id + "found"));
    }
    @Override
    public CarReturn Update(CarReturnDto carReturnlDto) {
        CarReturn carReturn = getById(carReturnlDto.getId());
        return Optional.of(carReturn)
                .map(entity -> carReturnAssembler.toCarReturn(carReturnlDto))
                .map(carReturnRepository::save)
                .orElseThrow(() ->new RuntimeException("carReturn of id "+carReturnlDto.getId()+"was not updated"));

    }
    @Override
    public void delete(long id) {
        getById(id);
        carReturnRepository.deleteById(id);
    }

    @Override
    public Page<CarReturn> search(CarReturnSearchDto carReturnSearchDto, Pageable pageable) {
        Specification<CarReturn> specification = CarReturnSpecification.getPredicate(carReturnSearchDto);
        return carReturnRepository.findAll(specification,pageable);
    }
}
