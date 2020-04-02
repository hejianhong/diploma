package com.edu.ctbu.demo.service;


import com.edu.ctbu.demo.domain.Cast;
import com.edu.ctbu.demo.domain.Members;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

@Service
public interface CastService {

    List<Cast> findAll();

    Page<Cast> findAll(Pageable pageable);

    public Page<Cast> findAll(Example<Cast> cast, Pageable pageable);

    public List<Cast> findByMembername(String membername);

    public List<Cast> findByCardnumber(String cardnumber);
}
