package com.edu.ctbu.demo.service;


import com.edu.ctbu.demo.domain.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface SupplierService {

    List<Supplier>finAll();

    public List<Supplier> findByName(String name);

    Supplier insert(Supplier supplier);

    Supplier update(Supplier supplier);

    void delete(Supplier supplier);
}
