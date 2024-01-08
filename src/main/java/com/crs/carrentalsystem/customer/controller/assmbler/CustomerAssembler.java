package com.crs.carrentalsystem.customer.controller.assmbler;
import com.crs.carrentalsystem.customer.controller.dto.CustomerDto;
import com.crs.carrentalsystem.customer.entity.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
@Component
@RequiredArgsConstructor
public class CustomerAssembler {
    public CustomerDto toCustomerDto(Customer from){
        CustomerDto to = new CustomerDto()
                .setId(from.getId())
                .setFirstName(from.getFirstName())
                .setLastName(from.getLastName())
                .setNationalId(from.getNationalId())
                .setHomeAddress(from.getHomeAddress())
                .setPhoneNo(from.getPhoneNo())
                .setEmail(from.getEmail());
        return to;
    }
    public  Customer toCustomer(CustomerDto from, Customer to){
        to.setId(from.getId())
                .setFirstName(from.getFirstName())
                      .setLastName(from.getLastName())
                      .setNationalId(from.getNationalId())
                      .setHomeAddress(from.getHomeAddress())
                .setPhoneNo(from.getPhoneNo())
                .setEmail(from.getEmail());
        return to;

    }
}
