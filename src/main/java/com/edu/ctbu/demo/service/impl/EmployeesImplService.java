package com.edu.ctbu.demo.service.impl;


import com.edu.ctbu.demo.dao.EmployeesRepository;
import com.edu.ctbu.demo.domain.Employees;
import com.edu.ctbu.demo.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeesImplService  implements EmployeesService {


    @Autowired
    EmployeesRepository employeesRepository;
    public List<Employees> findAll(){

        return employeesRepository.findAll();
    }

    public Page<Employees> findAll(Pageable pageable){

        return employeesRepository.findAll(pageable);

    }

    public Page<Employees> findAll(Example<Employees> employees , Pageable pageable){

        return employeesRepository.findAll(employees,pageable);
    }

    public List<Employees> findByNameAndPassword(String name,String password){

        return employeesRepository.findByNameAndPassword(name,password);
    }

    public Employees insert(Employees employees){

        return employeesRepository.save(employees);
    }

    public Employees update(Employees employees){

        return employeesRepository.save(employees);
    }

    public void delete(Employees employees){

        employeesRepository.delete(employees);
    }

    public void delete(Long id){

        Employees employees = new Employees();

        employees.setId(id);

        employeesRepository.delete(employees);
    }

    public Employees getById(Long id){

        return employeesRepository.findById(id).orElse(null);
    }
}
