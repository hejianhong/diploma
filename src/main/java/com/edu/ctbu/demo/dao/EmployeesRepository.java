package com.edu.ctbu.demo.dao;

import com.edu.ctbu.demo.domain.Employees;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeesRepository extends JpaRepository<Employees,Long> {

    public List<Employees> findByNameAndPassword(String name,String password);

    public Employees findByNumber(Long number);

    public Employees findByShift(String shift);

}
