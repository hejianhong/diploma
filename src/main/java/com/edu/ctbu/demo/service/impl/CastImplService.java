package com.edu.ctbu.demo.service.impl;


import com.edu.ctbu.demo.dao.CastRepository;
import com.edu.ctbu.demo.domain.Cast;
import com.edu.ctbu.demo.domain.Members;
import com.edu.ctbu.demo.service.CastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CastImplService implements CastService {

    @Autowired
    CastRepository castRepository;

    public List<Cast> findAll(){

        return castRepository.findAll();
    }

    public Page<Cast> findAll(Pageable pageable){

        return castRepository.findAll(pageable);
    }

    public Page<Cast> findAll(Example<Cast> cast ,Pageable pageable){

        return castRepository.findAll(cast,pageable);
    }


    public List<Cast> findByNameoftank(String nameoftank){

        return castRepository.findByNameoftank(nameoftank);
    }

    public List<Cast> findByProduct(String product){

        return castRepository.findByProduct(product);
    }

    public List<Cast> findByCardnumber(Long cardnumber){

        return castRepository.findByCardnumber(cardnumber);
    }

    public Cast insert(Cast cast){

        return castRepository.save(cast);
    }

    public Cast update(Cast cast){

        return castRepository.save(cast);
    }

    public Cast getById(Long id){

        return castRepository.findById(id).orElse(null);
    }

}
