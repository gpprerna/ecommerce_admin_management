package com.cs114127134.ecomadmin.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cs114127134.ecomadmin.entity.product;
import com.cs114127134.ecomadmin.repository.productRepo;

@Service
public class productService {
    @Autowired
    private productRepo productRepo;

    public void addproduct(product newproduct) {
        productRepo.save(newproduct);
    }

    public List<product> getAllproducts() {
        return productRepo.findAll();
    }

    public product getproductById(int id) {
        Optional<product> returnedproduct = productRepo.findById(id);
        if (returnedproduct.isPresent()) {
            return returnedproduct.get();
        }
        return null;
    }

    public void deleteproduct(int id) {
        productRepo.deleteById(id);
    }

    public List<product> getproductByPid(int pid) {
        Optional<List<product>> returnedproducts = productRepo.getAllproductsByPid(pid);
        if (returnedproducts.isPresent()) {
            return returnedproducts.get();
        }
        return null;
    }

    public List<product> getproductByEid(int eid) {
        Optional<List<product>> returnedproducts = productRepo.getAllproductsByEid(eid);
        if (returnedproducts.isPresent()) {
            return returnedproducts.get();
        }
        return null;
    }

    public List<product> getproductByCid(int cid) {
        Optional<List<product>> returnedproducts = productRepo.getAllproductsByCid(cid);
        if (returnedproducts.isPresent()) {
            return returnedproducts.get();
        }
        return null;
    }

    public void updateproductEidByPid(int pid, int eid) {
        productRepo.updateproductEidByPid(pid, eid);
    }
}
