package com.cs114127134.ecomadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;
import com.cs114127134.ecomadmin.entity.employee;

@Repository
public interface employeeRepo extends JpaRepository<employee, Integer> {
    @Query("SELECT e.eid from employee e")
    Optional<List<Integer>> getAllEid();
}