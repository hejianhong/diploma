package com.edu.ctbu.demo.service;


import com.edu.ctbu.demo.domain.Tank;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TankService {

    List<Tank> findAll();

    Page<Tank> findAll(Pageable pageable);

    public Page<Tank> findAll(Example<Tank> tank, Pageable pageable);

    public Tank findByNameoftank(String nameoftank);

    public List<Tank> findByProduct(String product);

    Tank insert(Tank tank);

    Tank update(Tank tank);

    void delete(Tank tank);

    void delete(Long id);

    Tank getById(Long id);
}
