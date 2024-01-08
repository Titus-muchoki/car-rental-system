package com.crs.carrentalsystem.customer.controller;
import com.crs.carrentalsystem.customer.controller.assmbler.CustomerAssembler;
import com.crs.carrentalsystem.customer.controller.dto.CustomerDto;
import com.crs.carrentalsystem.customer.controller.dto.CustomerSearchDto;
import com.crs.carrentalsystem.customer.service.CustomerService;
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
@RequestMapping("api/v1/customers")
public class CustomerController {
    private final CustomerAssembler customerAssembler;
    private final CustomerService customerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDto createCustomer(@RequestBody CustomerDto customerDto){
        return customerAssembler.toCustomerDto(customerService.createCustomer(customerDto));
    }

    @GetMapping("/{id}")
    public CustomerDto getCustomer(@PathVariable("id") Long id){
        return customerAssembler.toCustomerDto(customerService.get(id));
    }
    @PutMapping("/{id}")
    public CustomerDto updateCustomer(@PathVariable long id,  @RequestBody @Valid CustomerDto customerDto){

        if (id != (customerDto.getId())) {
            throw new RuntimeException("Path ID does not match DTO value");
        }
return customerAssembler.toCustomerDto(customerService.update(customerDto));
    }
    @DeleteMapping("/{id}")
    public void delete(long id){
        getCustomer(id);
        customerService.delete(id);
    }
    @PostMapping ("/search")
    @ResponseStatus(HttpStatus.OK)
    public Page<CustomerDto> search(@RequestBody CustomerSearchDto customerSearchDto, Pageable pageable) {
        return customerService.search(customerSearchDto, pageable)
                .map(customerAssembler::toCustomerDto);
    }

}
