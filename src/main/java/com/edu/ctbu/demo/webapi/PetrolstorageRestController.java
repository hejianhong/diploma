package com.edu.ctbu.demo.webapi;

import com.edu.ctbu.demo.core.PageUtils;
import com.edu.ctbu.demo.domain.Petrolstorage;
import com.edu.ctbu.demo.service.PetrolstorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webAPI/Petrolstorage")
public class PetrolstorageRestController {
    @Autowired
    private PetrolstorageService petrolstorageService;

    Pageable pageable;

    @GetMapping("/list")
    public List<Petrolstorage> getAll() {

        List<Petrolstorage> petrolstorages = petrolstorageService.findAll();
        return petrolstorages;
    }

    @GetMapping("/search")
    public PageUtils search(@RequestParam(value = "page", defaultValue = "0") Integer page,
                            @RequestParam(value = "size", defaultValue = "10") Integer size,
                            @RequestParam(value = "TankName", defaultValue = "") String TankName,
                            @RequestParam(value = "PetrolName", defaultValue = "") String PetrolName) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");

        Page<Petrolstorage> petrolstoragePage = null;
        if(StringUtils.isEmpty(TankName)&&StringUtils.isEmpty(PetrolName)){
            Pageable pageable = PageRequest.of(page, size, sort);
            petrolstoragePage=petrolstorageService.findAll(pageable);
        }else if(!(StringUtils.isEmpty(TankName))){
            Petrolstorage petrolstorage=new Petrolstorage();
            petrolstorage.setTankname(TankName);
            Pageable pageable=PageRequest.of(page,size,sort);
            ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("TankName",ExampleMatcher.GenericPropertyMatchers.contains());
            Example<Petrolstorage> example=Example.of(petrolstorage,matcher);
            petrolstoragePage=petrolstorageService.findAll(example,pageable);
        }else if(!(StringUtils.isEmpty(PetrolName))){
            Petrolstorage petrolstorage=new Petrolstorage();
            petrolstorage.setPetrolname(PetrolName);
            Pageable pageable=PageRequest.of(page,size,sort);
            ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("PetrolName",ExampleMatcher.GenericPropertyMatchers.contains());
            Example<Petrolstorage> example=Example.of(petrolstorage,matcher);
            petrolstoragePage=petrolstorageService.findAll(example,pageable);
        }
        PageUtils PageUtils = new PageUtils(petrolstoragePage.getContent(), petrolstoragePage.getTotalElements());
        return PageUtils;
    }

    @PutMapping("/update")
    public Petrolstorage update(Petrolstorage petrolstorage) {
        petrolstorage = petrolstorageService.update(petrolstorage);
        return petrolstorage;
    }

    @GetMapping("/get/{id}")
    public Petrolstorage get(@PathVariable Long id) {

        Petrolstorage petrolstorage = petrolstorageService.getById(id);
        return petrolstorage;
    }
}
