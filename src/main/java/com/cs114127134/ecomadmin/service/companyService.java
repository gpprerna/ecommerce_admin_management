package com.cs114127134.ecomadmin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs114127134.ecomadmin.entity.company;
import com.cs114127134.ecomadmin.repository.companyRepo;

@Service
public class companyService {
    @Autowired
    private companyRepo companyRepo;

    public void addcompany(company newcompany) {
        companyRepo.save(newcompany);
    }

    public List<company> getAllcompanys() {
        return companyRepo.findAll();
    }

    public company getcompanyById(int id) {
        Optional<company> returnedcompany = companyRepo.findById(id);
        if (returnedcompany.isPresent()) {
            return returnedcompany.get();
        }
        return null;
    }

    public void deletecompany(int id) {
        companyRepo.deleteById(id);
    }

    public List<company> getAllcompanysByCid(int cid) {
        Optional<List<company>> companysWithCid = companyRepo.findAllcompanysByCid(cid);
        if (companysWithCid.isPresent()) {
            return companysWithCid.get();
        }
        return null;
    }
}
