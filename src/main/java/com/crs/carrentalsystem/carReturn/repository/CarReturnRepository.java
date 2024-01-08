package com.crs.carrentalsystem.carReturn.repository;

import com.crs.carrentalsystem.carReturn.entity.CarReturn;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CarReturnRepository extends JpaRepository<CarReturn, Long>, JpaSpecificationExecutor<CarReturn> {
}
