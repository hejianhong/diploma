package com.edu.ctbu.demo.service.impl;

import com.edu.ctbu.demo.dao.GoodssalesRepository;
import com.edu.ctbu.demo.domain.Goodssales;
import com.edu.ctbu.demo.service.GoodssalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodssalesImplyService implements GoodssalesService {
    @Autowired
    GoodssalesRepository goodssalesRepository;

    public List<Goodssales> findAll() {

        return goodssalesRepository.findAll();
    }


    public Page<Goodssales> findAll(Pageable pageable) {
        return goodssalesRepository.findAll(pageable);
    }

    public Goodssales insert(Goodssales goodssales) {
        return goodssalesRepository.save(goodssales);
    }

    public Goodssales update(Goodssales goodssales) {
        return goodssalesRepository.save(goodssales);
    }

    public void delete(Long id) {
        Goodssales goodssales = new Goodssales();
        goodssales.setId(id);
        goodssalesRepository.delete(goodssales);
    }

    public Goodssales getById(Long id) {
        Goodssales goodssales = goodssalesRepository.findById(id).orElse(null);
        return goodssales;
    }

    public Page<Goodssales> findAll(Example<Goodssales> goodssales, Pageable pageable) {
        return goodssalesRepository.findAll(goodssales, pageable);
    }

}
