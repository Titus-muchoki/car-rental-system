package com.crs.carrentalsystem.carReturn.controller.assembler;

import com.crs.carrentalsystem.carReturn.controller.dto.CarReturnDto;
import com.crs.carrentalsystem.carReturn.entity.CarReturn;
import org.springframework.stereotype.Component;

@Component
public class CarReturnAssembler {
    public CarReturnDto toCarReturnDto(CarReturn from){
        CarReturnDto to = new CarReturnDto()
                .setCar_condtion(from.getCar_condtion())
                .setReturn_date(from.getReturn_date())
                .setId(from.getId());

        if(from.getCar() != null){
            to.setId(from.getCar().getId());
        }
        if ((from.getCustomer() != null)){
            to.setId(from.getCustomer().getId());

        }

        return  to;
    }
    public CarReturn toCarReturn(CarReturnDto from){
        CarReturn to = new CarReturn();
        to.setId(from.getId())
                .setCar_condtion(from.getCar_condtion())
                .setReturn_date(from.getReturn_date())

                .setPenalty_fee(from.getPenalty_fee());
        if ((from.getCar() != null)){
                to.setId(from.getCar().getId());
        }
        if(from.getCustomer() != null){
            to.setId(from.getCustomer().getId());
        }
        return to;
    }

}
