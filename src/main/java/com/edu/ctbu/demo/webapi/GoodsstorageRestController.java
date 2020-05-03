package com.edu.ctbu.demo.webapi;

import com.edu.ctbu.demo.core.PageUtils;
import com.edu.ctbu.demo.domain.Goodsstorage;
import com.edu.ctbu.demo.service.GoodsstorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webAPI/Goodsstorage")
public class GoodsstorageRestController {
    @Autowired
    private GoodsstorageService goodsstorageService;

    Pageable pageable;

    @GetMapping("/list")
    public List<Goodsstorage> getAll() {

        List<Goodsstorage> goodsstorages = goodsstorageService.findAll();
        return goodsstorages;
    }
    @GetMapping("/search")
    public PageUtils search(@RequestParam(value = "page", defaultValue = "0") Integer page,
                            @RequestParam(value = "size", defaultValue = "10") Integer size,
                            @RequestParam(value = "goodsname", defaultValue = "") String goodsname,
                            @RequestParam(value = "type", defaultValue = "") String type,
                            @RequestParam(value = "suppliers", defaultValue = "") String suppliers) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");

        Page<Goodsstorage> goodsstoragePage = null;
        if(StringUtils.isEmpty(goodsname)&&StringUtils.isEmpty(suppliers)) {
            Pageable pageable = PageRequest.of(page, size, sort);
            goodsstoragePage = goodsstorageService.findAll(pageable);
        }else if (!StringUtils.isEmpty(type)&&StringUtils.isEmpty(suppliers)&&StringUtils.isEmpty(goodsname)){
            Goodsstorage goodsstorage =new Goodsstorage();
            goodsstorage.setType(type);
            Pageable pageable=PageRequest.of(page,size,sort);
            ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("type",ExampleMatcher.GenericPropertyMatchers.contains());
            Example<Goodsstorage> example=Example.of(goodsstorage,matcher);
            goodsstoragePage= goodsstorageService.findAll(example,pageable);
        }else if (!StringUtils.isEmpty(goodsname)&&StringUtils.isEmpty(suppliers)&&StringUtils.isEmpty(type)){
            Goodsstorage goodsstorage =new Goodsstorage();
            goodsstorage.setGoodsname(goodsname);
            Pageable pageable=PageRequest.of(page,size,sort);
            ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("goodsname",ExampleMatcher.GenericPropertyMatchers.contains());
            Example<Goodsstorage> example=Example.of(goodsstorage,matcher);
            goodsstoragePage= goodsstorageService.findAll(example,pageable);
        }else if (!StringUtils.isEmpty(suppliers)&&StringUtils.isEmpty(goodsname)&&StringUtils.isEmpty(type)){
            Goodsstorage goodsstorage =new Goodsstorage();
            goodsstorage.setSuppliers(suppliers);
            Pageable pageable=PageRequest.of(page,size,sort);
            ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("suppliers",ExampleMatcher.GenericPropertyMatchers.contains());
            Example<Goodsstorage> example=Example.of(goodsstorage,matcher);
            goodsstoragePage= goodsstorageService.findAll(example,pageable);
        }else if (!StringUtils.isEmpty(suppliers)&&!(StringUtils.isEmpty(goodsname))||StringUtils.isEmpty(type)){
            Goodsstorage goodsstorage =new Goodsstorage();
            goodsstorage.setSuppliers(suppliers);
            goodsstorage.setGoodsname(goodsname);
            Pageable pageable=PageRequest.of(page,size,sort);
            ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("suppliers",ExampleMatcher.GenericPropertyMatchers.contains())
                    .withMatcher("goodsname",ExampleMatcher.GenericPropertyMatchers.contains());
            Example<Goodsstorage> example=Example.of(goodsstorage,matcher);
            goodsstoragePage= goodsstorageService.findAll(example,pageable);
        }
        PageUtils PageUtils = new PageUtils(goodsstoragePage.getContent(), goodsstoragePage.getTotalElements());
        return PageUtils;
    }


    @PostMapping("/insert")
    public Goodsstorage insert(Goodsstorage goodsstorage) {
        Goodsstorage goodsstorage1 = goodsstorageService.insert(goodsstorage);
        return goodsstorage1;
    }

    @PutMapping("/update")
    public Goodsstorage update(Goodsstorage goodsstorage) {
        goodsstorage= goodsstorageService.update(goodsstorage);
        return goodsstorage;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        goodsstorageService.delete(id);
    }

    @DeleteMapping("/deletelist/{ids}")
    public Long deletelist(@PathVariable Long[] ids) {
        long count = 0;
        for (Long id : ids) {
            goodsstorageService.delete(id);
            count++;
        }
        return count;
    }

    @GetMapping("/get/{id}")
    public Goodsstorage get(@PathVariable Long id) {

        Goodsstorage goodsstorage = goodsstorageService.getById(id);
        return goodsstorage;
    }
}
