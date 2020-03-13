package com.edu.ctbu.demo.webapi;


import com.edu.ctbu.demo.domain.Supplier;
import com.edu.ctbu.demo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/webapi/supplier")
public class SupplierRestController {

    @Autowired
    private SupplierService supplierService;


    @GetMapping("/list")
    public List<Supplier> getAll(){

        List<Supplier> supplier = supplierService.finAll();

        return supplier;
    }
}
