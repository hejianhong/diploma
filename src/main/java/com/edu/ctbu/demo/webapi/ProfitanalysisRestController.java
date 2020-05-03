package com.edu.ctbu.demo.webapi;

import com.edu.ctbu.demo.core.PageUtils;
import com.edu.ctbu.demo.domain.Profitanalysis;
import com.edu.ctbu.demo.service.ProfitanalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webAPI/Profitanalysis")
public class ProfitanalysisRestController {
    @Autowired
    private ProfitanalysisService profitanalysisService;

    Pageable pageable;

    @GetMapping("/list")
    public List<Profitanalysis> getAll() {

        List<Profitanalysis> profitanalysiss = profitanalysisService.findAll();
        return profitanalysiss;
    }
    @GetMapping("/search")
    public PageUtils search(@RequestParam(value = "page", defaultValue = "0") Integer page,
                            @RequestParam(value = "size", defaultValue = "9") Integer size) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");
        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Profitanalysis> profitanalysisPage=profitanalysisService.findAll(pageable);
        PageUtils pageUtils = new PageUtils(profitanalysisPage.getContent(), profitanalysisPage.getTotalElements());
        return pageUtils;
    }

    @PostMapping("/insert")
    public Profitanalysis insert(Profitanalysis profitanalysis) {
        Profitanalysis profitanalysis1=profitanalysisService.insert(profitanalysis);
        return profitanalysis1;
    }

    @PutMapping("/update")
    public Profitanalysis update(Profitanalysis profitanalysis) {
        profitanalysis = profitanalysisService.update(profitanalysis);
        return profitanalysis;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        profitanalysisService.delete(id);
    }

    @DeleteMapping("/deletelist/{ids}")
    public Long deletelist(@PathVariable Long[] ids) {
        long count = 0;
        for (Long id : ids) {
            profitanalysisService.delete(id);
            count++;
        }
        return count;
    }

    @GetMapping("/get/{id}")
    public Profitanalysis get(@PathVariable Long id) {

        Profitanalysis profitanalysis = profitanalysisService.getById(id);
        return profitanalysis;
    }
}
