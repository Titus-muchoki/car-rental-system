package com.crs.carrentalsystem.customer.repository;
import com.crs.carrentalsystem.customer.controller.dto.CustomerSearchDto;
import com.crs.carrentalsystem.customer.entity.Customer;
import org.springframework.data.jpa.domain.Specification;
import java.util.ArrayList;
import java.util.List;
public class CustomerSpecification {
        public static Specification<Customer> searchBy(String search) {
            Specification<Customer> nationalId = ((root, query, criteriaBuilder) ->
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("nationalId")), "%" + search.toLowerCase() + "%"));

            return Specification.where(nationalId);
        }

        public static Specification<Customer> getPredicate(CustomerSearchDto criteria) {
            List<Specification<Customer>> specifications = new ArrayList<>();

            if (criteria.getSearch() != null && !criteria.getSearch().isBlank()) {
                specifications.add(searchBy(criteria.getSearch()));
            }

            if (specifications.isEmpty()) {
                return ((root, query, criteriaBuilder) -> criteriaBuilder.conjunction());
            }

            Specification<Customer> specification = Specification.where(specifications.get(0));

            for (int i = 1; i < specifications.size(); i++) {
                specification = specification.and(specifications.get(i));
            }

            return specification;
        }
    }



