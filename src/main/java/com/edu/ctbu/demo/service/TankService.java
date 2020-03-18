package com.edu.ctbu.demo.service;


import com.edu.ctbu.demo.domain.Tank;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TankService {

    List<Tank> findAll();

    public List<Tank> findByNameoftank(String nameoftank);
}
