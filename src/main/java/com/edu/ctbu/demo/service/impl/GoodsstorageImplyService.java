package com.edu.ctbu.demo.service.impl;

import com.edu.ctbu.demo.dao.GoodsstorageRepository;
import com.edu.ctbu.demo.domain.Goodsstorage;
import com.edu.ctbu.demo.service.GoodsstorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsstorageImplyService implements GoodsstorageService {
    @Autowired
    GoodsstorageRepository goodsstorageRepository;

    public List<Goodsstorage> findAll() {

        return goodsstorageRepository.findAll();
    }


    public Page<Goodsstorage> findAll(Pageable pageable) {
        return goodsstorageRepository.findAll(pageable);
    }

    public Goodsstorage insert(Goodsstorage goodsstorage) {
        return goodsstorageRepository.save(goodsstorage);
    }

    public Goodsstorage update(Goodsstorage goodsstorage) {
        return goodsstorageRepository.save(goodsstorage);
    }

    public void delete(Long id) {
        Goodsstorage goodsstorage = new Goodsstorage();
        goodsstorage.setId(id);
        goodsstorageRepository.delete(goodsstorage);
    }

    public Goodsstorage getById(Long id) {
        Goodsstorage goodsstorage = goodsstorageRepository.findById(id).orElse(null);
        return goodsstorage;
    }

    public Page<Goodsstorage> findAll(Example<Goodsstorage> goodsstorage, Pageable pageable) {
        return goodsstorageRepository.findAll(goodsstorage, pageable);
    }
}