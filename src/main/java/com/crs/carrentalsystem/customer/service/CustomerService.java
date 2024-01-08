package com.crs.carrentalsystem.customer.service;

import com.crs.carrentalsystem.customer.controller.dto.CustomerSearchDto;
import com.crs.carrentalsystem.customer.controller.dto.CustomerDto;
import com.crs.carrentalsystem.customer.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    Customer createCustomer(CustomerDto customerDto);
    Customer get(Long id);
    Customer update(CustomerDto customerDto);
    void delete(Long id);
    Page<Customer> search(CustomerSearchDto customerSearchDto, Pageable pageable);
}
