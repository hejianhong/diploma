package com.edu.ctbu.demo.controller;


import com.edu.ctbu.demo.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployessController {

    @Autowired
    EmployeesService employeesService;

    @RequestMapping("/information/Employees/employeeslist")
    public String employees(){

        return "/information/Employees/employeeslist";
    }
}
