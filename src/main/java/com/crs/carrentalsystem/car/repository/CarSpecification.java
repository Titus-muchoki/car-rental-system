package com.crs.carrentalsystem.car.repository;

import com.crs.carrentalsystem.car.controller.dto.CarSearchDto;
import com.crs.carrentalsystem.car.entity.Car;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;

public class CarSpecification {

        public static Specification<Car> searchBy(String search) {
            Specification<Car> make = ((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("make")), "%" + search.toLowerCase() + "%"));

            Specification<Car> model = ((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("model")), "%" + search.toLowerCase() + "%"));

            Specification<Car> carRegNo = ((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("carRegNo")), "%" + search.toLowerCase() + "%"));


            return Specification.where(make).or(model).or(carRegNo);
        }

        public static Specification<Car> getPredicate(CarSearchDto criteria) {
            List<Specification<Car>> specifications = new ArrayList<>();

            if (criteria.getSearch() != null && !criteria.getSearch().isBlank()) {
                specifications.add(searchBy(criteria.getSearch()));
            }

            if (specifications.isEmpty()) {
                return ((root, query, criteriaBuilder) -> criteriaBuilder.conjunction());
            }

            Specification<Car> specification = Specification.where(specifications.get(0));

            for (int i = 1; i < specifications.size(); i++) {
                specification = specification.and(specifications.get(i));
            }

            return specification;
        }
    }

