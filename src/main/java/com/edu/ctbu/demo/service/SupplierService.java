package com.edu.ctbu.demo.service;


import com.edu.ctbu.demo.domain.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public interface SupplierService {

    List<Supplier> finAll();
}
