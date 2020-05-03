package com.edu.ctbu.demo.webapi;


import com.edu.ctbu.demo.core.PageUtils;
import com.edu.ctbu.demo.domain.Goodsprofits;
import com.edu.ctbu.demo.service.GoodsprofitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webAPI/Goodsprofits")
public class GoodsprofitsRestController {
    @Autowired
    private GoodsprofitsService goodsprofitsService;

    Pageable pageable;

    @GetMapping("/list")
    public List<Goodsprofits> getAll() {

        List<Goodsprofits> goodsprofits = goodsprofitsService.findAll();
        return goodsprofits;
    }
    @GetMapping("/search")
    public PageUtils search(@RequestParam(value = "page", defaultValue = "0") Integer page,
                            @RequestParam(value = "size", defaultValue = "10") Integer size,
                            @RequestParam(value = "goodsname", defaultValue = "") String goodsname) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");

        Page<Goodsprofits> goodsprofitsPage = null;
        if(StringUtils.isEmpty(goodsname)){
            Pageable pageable = PageRequest.of(page, size, sort);
            goodsprofitsPage= goodsprofitsService.findAll(pageable);
        }else if (!StringUtils.isEmpty(goodsname)){
            Goodsprofits goodsprofits =new Goodsprofits();
            goodsprofits.setGoodsname(goodsname);
            Pageable pageable=PageRequest.of(page,size,sort);
            ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("goodsname",ExampleMatcher.GenericPropertyMatchers.contains());
            Example<Goodsprofits> example=Example.of(goodsprofits,matcher);
            goodsprofitsPage= goodsprofitsService.findAll(example,pageable);
        }
        PageUtils pageUtils = new PageUtils(goodsprofitsPage.getContent(), goodsprofitsPage.getTotalElements());
        return pageUtils;
    }

    @PostMapping("/insert")
    public Goodsprofits insert(Goodsprofits goodsprofits) {
        Goodsprofits goodsprofits1 = goodsprofitsService.insert(goodsprofits);
        return goodsprofits1;
    }

    @PutMapping("/update")
    public Goodsprofits update(Goodsprofits goodsprofits) {
        goodsprofits = goodsprofitsService.update(goodsprofits);
        return goodsprofits;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        goodsprofitsService.delete(id);
    }

    @DeleteMapping("/deletelist/{ids}")
    public Long deletelist(@PathVariable Long[] ids) {
        long count = 0;
        for (Long id : ids) {
            goodsprofitsService.delete(id);
            count++;
        }
        return count;
    }

    @GetMapping("/get/{id}")
    public Goodsprofits get(@PathVariable Long id) {

        Goodsprofits goodsprofits = goodsprofitsService.getById(id);
        return goodsprofits;
    }
}
