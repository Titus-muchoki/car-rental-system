package com.crs.carrentalsystem.rental.repository;

import com.crs.carrentalsystem.car.controller.dto.CarSearchDto;
import com.crs.carrentalsystem.car.entity.Car;
import com.crs.carrentalsystem.rental.controller.dto.RentalSearchDto;
import com.crs.carrentalsystem.rental.entity.Rental;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class RentalSpecification {
        public static Specification<Rental> searchBy(String search) {
            Specification<Rental> issue_date = ((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("issue_date")), "%" + search.toLowerCase() + "%"));
            Specification<Rental> due_date = ((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("due_date")), "%" + search.toLowerCase() + "%"));
            return Specification.where(issue_date).or(due_date);
        }

        public static Specification<Rental> getPredicate(RentalSearchDto criteria) {
            List<Specification<Rental>> specifications = new ArrayList<>();

            if (criteria.getSearch() != null && !criteria.getSearch().isBlank()) {
                specifications.add(searchBy(criteria.getSearch()));
            }

            if (specifications.isEmpty()) {
                return ((root, query, criteriaBuilder) -> criteriaBuilder.conjunction());
            }

            Specification<Rental> specification = Specification.where(specifications.get(0));

            for (int i = 1; i < specifications.size(); i++) {
                specification = specification.and(specifications.get(i));
            }

            return specification;
        }
    }



