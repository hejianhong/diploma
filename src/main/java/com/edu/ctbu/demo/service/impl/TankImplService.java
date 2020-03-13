package com.edu.ctbu.demo.service.impl;


import com.edu.ctbu.demo.domain.Tank;
import com.edu.ctbu.demo.service.TankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TankImplService implements TankService {

    @Autowired
    TankService tankService;

    public List<Tank> findAll(){

        return tankService.findAll();
    }
}
