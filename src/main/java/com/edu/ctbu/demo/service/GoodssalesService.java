package com.edu.ctbu.demo.service;

import com.edu.ctbu.demo.domain.Goodssales;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodssalesService {

    List<Goodssales> findAll();

    Page<Goodssales> findAll(Pageable pageable);

    Page<Goodssales> findAll(Example<Goodssales> goodssales, Pageable pageable);

    Goodssales insert(Goodssales goodssales);

    Goodssales update(Goodssales goodssales);

    void delete(Long id);

    Goodssales getById(Long id);
}
