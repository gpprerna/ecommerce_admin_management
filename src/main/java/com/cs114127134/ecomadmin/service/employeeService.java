package com.cs114127134.ecomadmin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs114127134.ecomadmin.entity.employee;
import com.cs114127134.ecomadmin.repository.employeeRepo;

@Service
public class employeeService {
    @Autowired
    private employeeRepo employeeRepo;

    public void addemployee(employee newemployee) {
        employeeRepo.save(newemployee);
    }

    public List<employee> getAllemployees() {
        return employeeRepo.findAll();
    }

    public List<Integer> getAllEid() {
        Optional<List<Integer>> allEids = employeeRepo.getAllEid();
        if (allEids.isPresent()) {
            return allEids.get();
        }
        return null;
    }

    public employee getemployeeById(int id) {
        Optional<employee> returnedemployee = employeeRepo.findById(id);
        if (returnedemployee.isPresent()) {
            return returnedemployee.get();
        }
        return null;
    }

    public void deleteemployee(int id) {
        employeeRepo.deleteById(id);
    }
}
