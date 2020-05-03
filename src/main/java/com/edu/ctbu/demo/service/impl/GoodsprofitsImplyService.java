package com.edu.ctbu.demo.service.impl;

import com.edu.ctbu.demo.dao.GoodsprofitsRepository;
import com.edu.ctbu.demo.domain.Goodsprofits;
import com.edu.ctbu.demo.service.GoodsprofitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsprofitsImplyService implements GoodsprofitsService {
    @Autowired
    GoodsprofitsRepository goodsprofitsRepository;

    public List<Goodsprofits> findAll() {

        return goodsprofitsRepository.findAll();
    }


    public Page<Goodsprofits> findAll(Pageable pageable) {
        return goodsprofitsRepository.findAll(pageable);
    }

    public Goodsprofits insert(Goodsprofits goodsprofits) {
        return goodsprofitsRepository.save(goodsprofits);
    }

    public Goodsprofits update(Goodsprofits goodsprofits) {
        return goodsprofitsRepository.save(goodsprofits);
    }

    public void delete(Long id) {
        Goodsprofits goodsprofits = new Goodsprofits();
        goodsprofits.setId(id);
        goodsprofitsRepository.delete(goodsprofits);
    }

    public Goodsprofits getById(Long id) {
        Goodsprofits goodsprofits = goodsprofitsRepository.findById(id).orElse(null);
        return goodsprofits;
    }

    public Page<Goodsprofits> findAll(Example<Goodsprofits> goodsprofits, Pageable pageable) {
        return goodsprofitsRepository.findAll(goodsprofits, pageable);
    }
}
