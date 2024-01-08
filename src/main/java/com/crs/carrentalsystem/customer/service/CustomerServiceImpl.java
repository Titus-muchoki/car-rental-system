package com.crs.carrentalsystem.customer.service;

import com.crs.carrentalsystem.customer.controller.dto.CustomerSearchDto;
import com.crs.carrentalsystem.customer.repository.CustomerSpecification;
import com.crs.carrentalsystem.customer.controller.assmbler.CustomerAssembler;
import com.crs.carrentalsystem.customer.controller.dto.CustomerDto;
import com.crs.carrentalsystem.customer.entity.Customer;
import com.crs.carrentalsystem.customer.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.function.Function;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService{
    private final CustomerAssembler customerAssembler;
    private final CustomerRepository customerRepository;
    @Override
    public Customer createCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        return Optional.of(customer)
                .map(entity -> customerAssembler.toCustomer(customerDto,customer))
                .map(customerRepository::save)
                .orElseThrow(() -> new RuntimeException("Customer already exists"));
    }
    @Override
    public Customer get(Long id) {
        return Optional.of(id)
                .flatMap(customerRepository::findById)
                .orElseThrow(() -> new RuntimeException("Customer od id"+ id+ "not found"));
    }


    @Override
    public Customer update(CustomerDto customerDto) {

        Customer customer = get(customerDto.getId());
        return Optional.of(customer)
                .map(entity -> customerAssembler.toCustomer(customerDto,customer))
                .map(customerRepository::save)
                .orElseThrow(() ->new RuntimeException("Customer of id was not updated"));

    }

    @Override
    public void delete(Long id) {
        get(id);
        customerRepository.deleteById(id);
    }

    @Override
    public Page<Customer> search(CustomerSearchDto customerSearchDto, Pageable pageable) {
        Specification<Customer> customerspecification = CustomerSpecification.getPredicate(customerSearchDto);
        return customerRepository.findAll(customerspecification, pageable);
    }


}
