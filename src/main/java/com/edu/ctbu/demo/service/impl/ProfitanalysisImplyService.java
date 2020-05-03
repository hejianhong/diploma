package com.edu.ctbu.demo.service.impl;

import com.edu.ctbu.demo.dao.ProfitanalysisRepository;
import com.edu.ctbu.demo.domain.Profitanalysis;
import com.edu.ctbu.demo.service.ProfitanalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfitanalysisImplyService implements ProfitanalysisService {
    @Autowired
    ProfitanalysisRepository profitanalysisRepository;

    public List<Profitanalysis> findAll() {

        return profitanalysisRepository.findAll();
    }

    public Page<Profitanalysis> findAll(Pageable pageable) {
        return profitanalysisRepository.findAll(pageable);
    }

    public Profitanalysis insert(Profitanalysis profitanalysis) {
        return profitanalysisRepository.save(profitanalysis);
    }

    public Profitanalysis update(Profitanalysis profitanalysis) {
        return profitanalysisRepository.save(profitanalysis);
    }

    public void delete(Long id) {
        Profitanalysis profitanalysis = new Profitanalysis();
        profitanalysis.setId(id);
        profitanalysisRepository.delete(profitanalysis);
    }

    public Profitanalysis getById(Long id) {
        Profitanalysis profitanalysis = profitanalysisRepository.findById(id).orElse(null);
        return profitanalysis;
    }

    public Page<Profitanalysis> findAll(Example<Profitanalysis> profitanalysis, Pageable pageable) {
        return profitanalysisRepository.findAll(profitanalysis, pageable);
    }
}
