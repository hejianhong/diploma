package com.edu.ctbu.demo.service.impl;


import com.edu.ctbu.demo.dao.TopupRepository;
import com.edu.ctbu.demo.domain.Topup;
import com.edu.ctbu.demo.service.TopupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopupImplService implements TopupService {

    @Autowired
    TopupRepository topupRepository;

    public List<Topup> findAll(){

        return topupRepository.findAll();
    }

    public Page<Topup> findAll(Pageable pageable){

        return topupRepository.findAll(pageable);
    }

    public Page<Topup> findAll(Example<Topup> topup,Pageable pageable){

        return topupRepository.findAll(topup,pageable);
    }

    public List<Topup> findByCardnumber(Long cardnumber){

        return topupRepository.findByCardnumber(cardnumber);
    }

    public Topup insert(Topup topup){

        return topupRepository.save(topup);
    }

}
