package com.edu.ctbu.demo.service;


import com.edu.ctbu.demo.domain.Employees;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EmployeesService {

    List<Employees>findAll();

    Page<Employees> findAll(Pageable pageable);

    public Page<Employees> findAll(Example<Employees> employees, Pageable pageable);

    public List<Employees> findByNameAndPassword(String name,String password);

    public Employees finByNumber(Long number);

    public Employees findByShift(String shift);

    Employees insert(Employees employees);

    Employees update(Employees employees);

    void delete(Employees employees);

    void delete(Long id);

    Employees getById(Long id);

//    Employees getByNumber(String number);
}
