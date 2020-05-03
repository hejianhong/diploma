package com.edu.ctbu.demo.service;

import com.edu.ctbu.demo.domain.Petrolstorage;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PetrolstorageService {

    List<Petrolstorage> findAll();

    Page<Petrolstorage> findAll(Pageable pageable);

    Page<Petrolstorage> findAll(Example<Petrolstorage> petrolstorage, Pageable pageable);

    Petrolstorage insert(Petrolstorage petrolstorage);

    Petrolstorage update(Petrolstorage petrolstorage);

    void delete(Long id);

    Petrolstorage getById(Long id);
}
