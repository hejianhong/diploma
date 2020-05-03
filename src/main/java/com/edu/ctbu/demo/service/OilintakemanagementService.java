package com.edu.ctbu.demo.service;

import com.edu.ctbu.demo.domain.Oilintakemanagement;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface OilintakemanagementService {
    List<Oilintakemanagement> findAll();

    Page<Oilintakemanagement> findAll(Pageable pageable);

    Page<Oilintakemanagement> findAll(Example<Oilintakemanagement> oilintakemanagement, Pageable pageable);

    Oilintakemanagement insert(Oilintakemanagement oilintakemanagement);

    Oilintakemanagement update(Oilintakemanagement oilintakemanagement);

    void delete(Long id);

    Oilintakemanagement getById(Long id);
}
