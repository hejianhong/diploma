package com.edu.ctbu.demo.webapi;


import com.edu.ctbu.demo.domain.Employees;
import com.edu.ctbu.demo.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/webapi/employees")
public class EmployeesRestController {


    @Autowired
    private EmployeesService employeesService;

    @GetMapping("/list")
    public List<Employees> getAll(){

        List<Employees> employees =employeesService.findAll();

        return employees;
    }
}
