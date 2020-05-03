package com.edu.ctbu.demo.service.impl;

import com.edu.ctbu.demo.dao.PetrolsalesRepository;
import com.edu.ctbu.demo.domain.Petrolsales;
import com.edu.ctbu.demo.service.PetrolsalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetrolsalesImplyService implements PetrolsalesService {
    @Autowired
    PetrolsalesRepository petrolsalesRepository;

    public List<Petrolsales> findAll() {

        return petrolsalesRepository.findAll();
    }


    public Page<Petrolsales> findAll(Pageable pageable) {
        return petrolsalesRepository.findAll(pageable);
    }

    public Petrolsales insert(Petrolsales petrolsales) {
        return petrolsalesRepository.save(petrolsales);
    }

    public Petrolsales update(Petrolsales petrolsales) {
        return petrolsalesRepository.save(petrolsales);
    }

    public void delete(Long id) {
        Petrolsales petrolsales = new Petrolsales();
        petrolsales.setId(id);
        petrolsalesRepository.delete(petrolsales);
    }

    public Petrolsales getById(Long id) {
        Petrolsales petrolsales = petrolsalesRepository.findById(id).orElse(null);
        return petrolsales;
    }

    public Page<Petrolsales> findAll(Example<Petrolsales> petrolsales, Pageable pageable) {
        return petrolsalesRepository.findAll(petrolsales, pageable);
    }
}
