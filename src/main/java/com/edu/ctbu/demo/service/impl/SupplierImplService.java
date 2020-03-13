package com.edu.ctbu.demo.service.impl;

import com.edu.ctbu.demo.domain.Supplier;
import com.edu.ctbu.demo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SupplierImplService implements SupplierService {

    @Autowired
    SupplierService supplierService;

    public List<Supplier> finAll(){

        return supplierService.finAll();
    }
}
