package com.edu.ctbu.demo.service;


import com.edu.ctbu.demo.domain.Topup;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TopupService {

    List<Topup> findAll();

    Page<Topup> findAll(Pageable pageable);

    public Page<Topup> findAll(Example<Topup> topup,Pageable pageable);

    public List<Topup> findByCardnumber(Long cardnumber);

    Topup insert(Topup topup);

}
