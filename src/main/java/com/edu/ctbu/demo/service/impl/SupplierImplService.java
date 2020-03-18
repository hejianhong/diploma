package com.edu.ctbu.demo.service.impl;

import com.edu.ctbu.demo.dao.SupplierRepository;
import com.edu.ctbu.demo.domain.Supplier;
import com.edu.ctbu.demo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SupplierImplService implements SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public List<Supplier> finAll(){

        return supplierRepository.findAll();
    }

    public List<Supplier> findByName(String name){

        return supplierRepository.findByName(name);
    }

    public Supplier insert(Supplier supplier){

        return supplierRepository.save(supplier);
    }

    public Supplier update(Supplier supplier){

        return supplierRepository.save(supplier);
    }

    public void delete(Supplier supplier){

        supplierRepository.delete(supplier);
    }
}
