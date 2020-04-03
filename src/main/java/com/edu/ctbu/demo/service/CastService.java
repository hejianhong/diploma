package com.edu.ctbu.demo.service;


import com.edu.ctbu.demo.domain.Cast;
import com.edu.ctbu.demo.domain.Members;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CastService {

    List<Cast> findAll();

    Page<Cast> findAll(Pageable pageable);

    public Page<Cast> findAll(Example<Cast> cast, Pageable pageable);

    public List<Cast> findByNameoftank(String nameoftank);

    public List<Cast> findByProduct(String product);

    Cast insert(Cast cast);

    Cast update(Cast cast);

    Cast getById(Long id);
}
