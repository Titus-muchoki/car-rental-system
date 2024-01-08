package com.crs.carrentalsystem.rental.repository;

import com.crs.carrentalsystem.rental.entity.Rental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface RentalRepository extends JpaRepository<Rental,Long>, JpaSpecificationExecutor<Rental> {
}
