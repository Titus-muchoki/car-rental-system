package com.crs.carrentalsystem.carReturn.repository;

import com.crs.carrentalsystem.carReturn.controller.dto.CarReturnSearchDto;
import com.crs.carrentalsystem.carReturn.entity.CarReturn;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CarReturnSpecification {
    public static Specification<CarReturn> searchBy(String search) {
        Specification<CarReturn>  return_date = ((root, query, criteriaBuilder) ->
                criteriaBuilder.like(criteriaBuilder.lower(root.get("return_date")), "%" + search.toLowerCase() + "%"));
        return Specification.where( return_date);
    }
    public static Specification<CarReturn> getPredicate(CarReturnSearchDto criteria) {
        List<Specification<CarReturn>> specifications = new ArrayList<>();
        if (criteria.getSearch() != null && !criteria.getSearch().isBlank()) {
            specifications.add(searchBy(criteria.getSearch()));
        }
        if (specifications.isEmpty()) {
            return ((root, query, criteriaBuilder) -> criteriaBuilder.conjunction());
        }
        Specification<CarReturn> specification = Specification.where(specifications.get(0));
        for (int i = 1; i < specifications.size(); i++) {
            specification = specification.and(specifications.get(i));
        }
        return specification;
    }

}
