package com.edu.ctbu.demo.service;


import com.edu.ctbu.demo.domain.Employees;
import com.edu.ctbu.demo.domain.Members;
import com.edu.ctbu.demo.domain.Supplier;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface SupplierService {

    List<Supplier>finAll();

    Page<Supplier> findAll(Pageable pageable);

    public Page<Supplier> findAll(Example<Supplier> supplier, Pageable pageable);

    public List<Supplier> findByName(String name);

    Supplier insert(Supplier supplier);

    Supplier update(Supplier supplier);

    void delete(Supplier supplier);

    void delete(Long id);

    Supplier getById(Long id);
}
