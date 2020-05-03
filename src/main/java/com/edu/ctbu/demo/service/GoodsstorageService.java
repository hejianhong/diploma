package com.edu.ctbu.demo.service;

import com.edu.ctbu.demo.domain.Goodsstorage;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GoodsstorageService {
    List<Goodsstorage> findAll();

    Page<Goodsstorage> findAll(Pageable pageable);

    Page<Goodsstorage> findAll(Example<Goodsstorage> goodsstorage, Pageable pageable);

    Goodsstorage insert(Goodsstorage goodsstorage);

    Goodsstorage update(Goodsstorage goodsstorage);

    void delete(Long id);

    Goodsstorage getById(Long id);
}
