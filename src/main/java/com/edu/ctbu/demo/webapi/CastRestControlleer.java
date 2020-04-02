package com.edu.ctbu.demo.webapi;


import com.edu.ctbu.demo.domain.Cast;
import com.edu.ctbu.demo.service.CastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/webapi/cast")
public class CastRestControlleer {

    @Autowired
    private CastService castService;

    @GetMapping("/list")
    public List<Cast> getAll(){

        List<Cast> casts = castService.findAll();

        return casts;
    }
}
