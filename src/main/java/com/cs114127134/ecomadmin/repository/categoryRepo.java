package com.cs114127134.ecomadmin.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

import com.cs114127134.ecomadmin.entity.category;

@Repository
public interface categoryRepo extends JpaRepository<category, Integer> {
    @Query("SELECT ca from category ca WHERE ca.caid = ?1")
    Optional<List<category>> findAllCategorysByCaid(int caid);
}
