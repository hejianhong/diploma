package com.edu.ctbu.demo.service.impl;

import com.edu.ctbu.demo.dao.PetrolstorageRepository;
import com.edu.ctbu.demo.domain.Petrolstorage;
import com.edu.ctbu.demo.service.PetrolstorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetrolstorageImplyService implements PetrolstorageService {
    @Autowired
    PetrolstorageRepository petrolstorageRepository;

    public List<Petrolstorage> findAll() {

        return petrolstorageRepository.findAll();
    }

    public Page<Petrolstorage> findAll(Pageable pageable) {
        return petrolstorageRepository.findAll(pageable);
    }

    public Petrolstorage insert(Petrolstorage petrolstorage) {
        return petrolstorageRepository.save(petrolstorage);
    }

    public Petrolstorage update(Petrolstorage petrolstorage) {
        return petrolstorageRepository.save(petrolstorage);
    }

    public void delete(Long id) {
        Petrolstorage petrolstorage = new Petrolstorage();
        petrolstorage.setId(id);
        petrolstorageRepository.delete(petrolstorage);
    }

    public Petrolstorage getById(Long id) {
        Petrolstorage petrolstorage = petrolstorageRepository.findById(id).orElse(null);
        return petrolstorage;
    }

    public Page<Petrolstorage> findAll(Example<Petrolstorage> petrolstorage, Pageable pageable) {
        return petrolstorageRepository.findAll(petrolstorage, pageable);
    }
}
