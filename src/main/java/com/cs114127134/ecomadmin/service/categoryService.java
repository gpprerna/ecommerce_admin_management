package com.cs114127134.ecomadmin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs114127134.ecomadmin.entity.category;
import com.cs114127134.ecomadmin.repository.categoryRepo;

@Service
public class categoryService {
    @Autowired
    private categoryRepo categoryRepo;

    public void addcategory(category newcategory) {
        categoryRepo.save(newcategory);
    }

    public List<category> getAllcategorys() {
        return categoryRepo.findAll();
    }

    public category getcategoryById(int id) {
        Optional<category> returnedcategory = categoryRepo.findById(id);
        if (returnedcategory.isPresent()) {
            return returnedcategory.get();
        }
        return null;
    }

    public void deletecategory(int id) {
        categoryRepo.deleteById(id);
    }

    public List<category> getAllcategorysByCaid(int caid) {
        Optional<List<category>> categorysWithCaid = categoryRepo.findAllCategorysByCaid(caid);
        if (categorysWithCaid.isPresent()) {
            return categorysWithCaid.get();
        }
        return null;
    }
}
