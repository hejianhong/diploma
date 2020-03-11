package com.edu.ctbu.demo.service;


import com.edu.ctbu.demo.domain.Employees;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeesService {

    List<Employees>findAll();

    public List<Employees> findByNameAndPassword(String name,String password);

    Employees insert(Employees employees);

    Employees update(Employees employees);

    void delete(Employees employees);

    void delete(Long id);

    Employees getById(Long id);
}
