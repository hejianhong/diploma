package com.edu.ctbu.demo.service.impl;

import com.edu.ctbu.demo.dao.OilintakemanagementRepository;
import com.edu.ctbu.demo.domain.Oilintakemanagement;
import com.edu.ctbu.demo.service.OilintakemanagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OilintakemanagementImplyService implements OilintakemanagementService {
    @Autowired
    OilintakemanagementRepository oilintakemanagementRepository;

    public List<Oilintakemanagement> findAll() {

        return oilintakemanagementRepository.findAll();
    }


    public Page<Oilintakemanagement> findAll(Pageable pageable) {
        return oilintakemanagementRepository.findAll(pageable);
    }

    public Oilintakemanagement insert(Oilintakemanagement oilintakemanagement) {
        return oilintakemanagementRepository.save(oilintakemanagement);
    }

    public Oilintakemanagement update(Oilintakemanagement oilintakemanagement) {
        return oilintakemanagementRepository.save(oilintakemanagement);
    }

    public void delete(Long id) {
        Oilintakemanagement oilintakemanagement = new Oilintakemanagement();
        oilintakemanagement.setId(id);
        oilintakemanagementRepository.delete(oilintakemanagement);
    }

    public Oilintakemanagement getById(Long id) {
        Oilintakemanagement oilintakemanagement = oilintakemanagementRepository.findById(id).orElse(null);
        return oilintakemanagement;
    }

    public Page<Oilintakemanagement> findAll(Example<Oilintakemanagement> oilintakemanagement, Pageable pageable) {
        return oilintakemanagementRepository.findAll(oilintakemanagement, pageable);
    }

}
