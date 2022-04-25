package com.cs114127134.ecomadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.jpa.repository.Query;


import java.util.*;

import com.cs114127134.ecomadmin.entity.product;

@Repository
public interface productRepo extends JpaRepository<product, Integer> {
    @Query("SELECT p from product p WHERE p.pid = ?1")
    Optional<List<product>> getAllproductsByPid(int pid);

    @Query("SELECT p from product p WHERE p.eid = ?1")
    Optional<List<product>> getAllproductsByEid(int eid);

    @Query("SELECT p from product p WHERE p.cid = ?1")
    Optional<List<product>> getAllproductsByCid(int cid);
    
    @Modifying
    @Query("UPDATE product p SET p.eid = ?2 WHERE p.pid = ?1")
    @Transactional
    public void  updateproductEidByPid(int pid, int eid);
}