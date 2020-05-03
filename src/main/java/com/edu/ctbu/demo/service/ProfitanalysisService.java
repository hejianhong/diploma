package com.edu.ctbu.demo.service;

import com.edu.ctbu.demo.domain.Profitanalysis;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfitanalysisService {

    List<Profitanalysis> findAll();

    Page<Profitanalysis> findAll(Pageable pageable);

    Page<Profitanalysis> findAll(Example<Profitanalysis> profitanalysis, Pageable pageable);

    Profitanalysis insert(Profitanalysis profitanalysis);

    Profitanalysis update(Profitanalysis profitanalysis);

    void delete(Long id);

    Profitanalysis getById(Long id);
}
