package com.edu.ctbu.demo.dao;

import com.edu.ctbu.demo.domain.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SupplierRepository extends JpaRepository<Supplier,Long> {

    public List<Supplier> findByName(String name);
}
