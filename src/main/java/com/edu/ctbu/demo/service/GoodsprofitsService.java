package com.edu.ctbu.demo.service;

import com.edu.ctbu.demo.domain.Goodsprofits;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodsprofitsService {
    List<Goodsprofits> findAll();

    Page<Goodsprofits> findAll(Pageable pageable);

    Page<Goodsprofits> findAll(Example<Goodsprofits> goodsprofits, Pageable pageable);

    Goodsprofits insert(Goodsprofits goodsprofits);

    Goodsprofits update(Goodsprofits goodsprofits);

    void delete(Long id);

    Goodsprofits getById(Long id);
}
