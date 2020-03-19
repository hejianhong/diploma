package com.edu.ctbu.demo.service.impl;


import com.edu.ctbu.demo.dao.TankRepository;
import com.edu.ctbu.demo.domain.Members;
import com.edu.ctbu.demo.domain.Tank;
import com.edu.ctbu.demo.service.TankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TankImplService implements TankService {

    @Autowired
    TankRepository tankRepository;

    public List<Tank> findAll(){

        return tankRepository.findAll();
    }

    public Page<Tank> findAll(Pageable pageable){

        return tankRepository.findAll(pageable);

    }

    public Page<Tank> findAll(Example<Tank> tank , Pageable pageable){

        return tankRepository.findAll(tank,pageable);
    }

    public List<Tank> findByNameoftank(String nameoftank){

        return tankRepository.findByNameoftank(nameoftank);
    }

    public Tank insert(Tank tank){

        return tankRepository.save(tank);
    }

    public Tank update(Tank tank){

        return tankRepository.save(tank);
    }

    public void delete(Tank tank){

        tankRepository.delete(tank);
    }
}
