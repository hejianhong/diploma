package com.edu.ctbu.demo.webapi;

import com.edu.ctbu.demo.core.PageUtils;
import com.edu.ctbu.demo.domain.Petrolsales;
import com.edu.ctbu.demo.service.PetrolsalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webAPI/Petrolsales")
public class PetrolsalesRestController {
    @Autowired
    private PetrolsalesService petrolsalesService;

    Pageable pageable;

    @GetMapping("/list")
    public List<Petrolsales> getAll() {

        List<Petrolsales> petrolsaless = petrolsalesService.findAll();
        return petrolsaless;
    }

    @GetMapping("/search")
    public PageUtils search(@RequestParam(value = "page", defaultValue = "0") Integer page,
                            @RequestParam(value = "size", defaultValue = "10") Integer size,
                            @RequestParam(value = "operator", defaultValue = "") String operator,
                            @RequestParam(value = "oilgun", defaultValue = "") String oilgun,
                            @RequestParam(value = "name", defaultValue = "") String name,
                            @RequestParam(value = "cardnumber", defaultValue = "") String cardnumber) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");

        Page<Petrolsales> petrolsalesPage = null;
        if(StringUtils.isEmpty(operator)&&StringUtils.isEmpty(oilgun)&&StringUtils.isEmpty(name)
                &&StringUtils.isEmpty(cardnumber)){
            Pageable pageable = PageRequest.of(page, size, sort);
            petrolsalesPage=petrolsalesService.findAll(pageable);
        }else if(!(StringUtils.isEmpty(operator))){
            Petrolsales petrolsales=new Petrolsales();
            petrolsales.setOperator(operator);
            Pageable pageable=PageRequest.of(page,size,sort);
            ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("operator",ExampleMatcher.GenericPropertyMatchers.contains());
            Example<Petrolsales> example=Example.of(petrolsales,matcher);
            petrolsalesPage=petrolsalesService.findAll(example,pageable);
        }else if(!(StringUtils.isEmpty(oilgun))){
            Petrolsales petrolsales=new Petrolsales();
            petrolsales.setOilgun(oilgun);
            Pageable pageable=PageRequest.of(page,size,sort);
            ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("oilgun",ExampleMatcher.GenericPropertyMatchers.contains());
            Example<Petrolsales> example=Example.of(petrolsales,matcher);
            petrolsalesPage=petrolsalesService.findAll(example,pageable);
        }else if(!(StringUtils.isEmpty(name))){
            Petrolsales petrolsales=new Petrolsales();
            petrolsales.setName(name);
            Pageable pageable=PageRequest.of(page,size,sort);
            ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("name",ExampleMatcher.GenericPropertyMatchers.exact());
            Example<Petrolsales> example=Example.of(petrolsales,matcher);
            petrolsalesPage=petrolsalesService.findAll(example,pageable);
        }else if(!(StringUtils.isEmpty(cardnumber))){
            Petrolsales petrolsales=new Petrolsales();
            petrolsales.setCardnumber(cardnumber);
            Pageable pageable=PageRequest.of(page,size,sort);
            ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("cardnumber",ExampleMatcher.GenericPropertyMatchers.contains());
            Example<Petrolsales> example=Example.of(petrolsales,matcher);
            petrolsalesPage=petrolsalesService.findAll(example,pageable);
        }
        PageUtils PageUtils = new PageUtils(petrolsalesPage.getContent(), petrolsalesPage.getTotalElements());
        return PageUtils;
    }

    @PostMapping("/insert")
    public Petrolsales insert(Petrolsales petrolsales) {
        Petrolsales petrolsales1=petrolsalesService.insert(petrolsales);
        return petrolsales1;
    }

    @PutMapping("/update")
    public Petrolsales update(Petrolsales petrolsales) {
        petrolsales = petrolsalesService.update(petrolsales);
        return petrolsales;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        petrolsalesService.delete(id);
    }

    @DeleteMapping("/deletelist/{ids}")
    public Long deletelist(@PathVariable Long[] ids) {
        long count = 0;
        for (Long id : ids) {
            petrolsalesService.delete(id);
            count++;
        }
        return count;
    }

    @GetMapping("/get/{id}")
    public Petrolsales get(@PathVariable Long id) {

        Petrolsales petrolsales = petrolsalesService.getById(id);
        return petrolsales;
    }
}
