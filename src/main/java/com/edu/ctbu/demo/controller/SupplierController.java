package com.edu.ctbu.demo.controller;


import com.edu.ctbu.demo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @RequestMapping("/information/Supplier/supplierlist")
    public String supplier(){

        return "/information/Supplier/supplierlist";
    }
}
