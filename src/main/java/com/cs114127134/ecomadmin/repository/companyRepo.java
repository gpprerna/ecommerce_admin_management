package com.cs114127134.ecomadmin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.*;

import com.cs114127134.ecomadmin.entity.company;

@Repository
public interface companyRepo extends JpaRepository<company, Integer> {
    @Query("SELECT c FROM company c WHERE c.cid = ?1")
    Optional<List<company>> findAllcompanysByCid(int cid);
}