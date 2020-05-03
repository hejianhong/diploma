package com.edu.ctbu.demo.service;

import com.edu.ctbu.demo.domain.Petrolsales;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PetrolsalesService {
    List<Petrolsales> findAll();

    Page<Petrolsales> findAll(Pageable pageable);

    Page<Petrolsales> findAll(Example<Petrolsales> petrolsales, Pageable pageable);

    Petrolsales insert(Petrolsales petrolsales);

    Petrolsales update(Petrolsales petrolsales);

    void delete(Long id);

    Petrolsales getById(Long id);
}
