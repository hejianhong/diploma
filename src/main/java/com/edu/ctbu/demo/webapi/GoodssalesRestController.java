package com.edu.ctbu.demo.webapi;

import com.edu.ctbu.demo.core.PageUtils;
import com.edu.ctbu.demo.domain.Goodssales;
import com.edu.ctbu.demo.service.GoodssalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webAPI/Goodssales")
public class GoodssalesRestController {
    @Autowired
    private GoodssalesService goodssalesService;

    Pageable pageable;

    @GetMapping("/list")
    public List<Goodssales> getAll() {

        List<Goodssales> goodssales = goodssalesService.findAll();
        return goodssales;
    }
    @GetMapping("/search")
    public PageUtils search(@RequestParam(value = "page", defaultValue = "0") Integer page,
                            @RequestParam(value = "size", defaultValue = "10") Integer size,
                            @RequestParam(value = "tel", defaultValue = "") String tel) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");

        Page<Goodssales> goodssalesPage = null;
        if(StringUtils.isEmpty(tel)){
            Pageable pageable = PageRequest.of(page, size, sort);
            goodssalesPage= goodssalesService.findAll(pageable);
        }else {
            Goodssales goodssales = new Goodssales();
            goodssales.setTel(tel);
            Pageable pageable = PageRequest.of(page, size, sort);
            ExampleMatcher matcher = ExampleMatcher.matching().withMatcher("tel", ExampleMatcher.GenericPropertyMatchers.exact());
            Example<Goodssales> example = Example.of(goodssales, matcher);
            goodssalesPage = goodssalesService.findAll(example, pageable);
        }
        PageUtils PageUtils = new PageUtils(goodssalesPage.getContent(), goodssalesPage.getTotalElements());
        return PageUtils;
    }

    @PostMapping("/insert")
    public Goodssales insert(Goodssales goodssales) {
        Goodssales goodssales1 = goodssalesService.insert(goodssales);
        return goodssales1;
    }

    @PutMapping("/update")
    public Goodssales update(Goodssales goodssales) {
        goodssales = goodssalesService.update(goodssales);
        return goodssales;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        goodssalesService.delete(id);
    }

    @DeleteMapping("/deletelist/{ids}")
    public Long deletelist(@PathVariable Long[] ids) {
        long count = 0;
        for (Long id : ids) {
            goodssalesService.delete(id);
            count++;
        }
        return count;
    }

    @GetMapping("/get/{id}")
    public Goodssales get(@PathVariable Long id) {

        Goodssales goodssales = goodssalesService.getById(id);
        return goodssales;
    }
}
