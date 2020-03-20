package com.edu.ctbu.demo.service.impl;

import com.edu.ctbu.demo.dao.SupplierRepository;
import com.edu.ctbu.demo.domain.Employees;
import com.edu.ctbu.demo.domain.Members;
import com.edu.ctbu.demo.domain.Supplier;
import com.edu.ctbu.demo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SupplierImplService implements SupplierService {

    @Autowired
    SupplierRepository supplierRepository;

    public List<Supplier> finAll(){

        return supplierRepository.findAll();
    }

    public Page<Supplier> findAll(Pageable pageable){

        return supplierRepository.findAll(pageable);

    }

    public Page<Supplier> findAll(Example<Supplier> supplier , Pageable pageable){

        return supplierRepository.findAll(supplier,pageable);
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

    public void delete(Long id){

        Supplier supplier = new Supplier();

        supplier.setId(id);

        supplierRepository.delete(supplier);
    }

    public Supplier getById(Long id){

        return supplierRepository.findById(id).orElse(null);
    }
}
