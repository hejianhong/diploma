package com.edu.ctbu.demo.service.impl;


import com.edu.ctbu.demo.domain.Cast;
import com.edu.ctbu.demo.domain.Members;
import com.edu.ctbu.demo.service.CastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public class CastImpService implements CastService {

    @Autowired
    CastService castService;

    public List<Cast> findAll(){

        return castService.findAll();
    }

    public Page<Cast> findAll(Pageable pageable){

        return castService.findAll(pageable);
    }

    public Page<Cast> findAll(Example<Cast> cast, Pageable pageable){

        return castService.findAll(cast,pageable);
    }

    public List<Cast> findByMembername(String membername){

        return castService.findByMembername(membername);
    }

    public List<Cast> findByCardnumber(String cardnumber){

        return castService.findByCardnumber(cardnumber);
    }
}
