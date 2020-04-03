package com.edu.ctbu.demo.controller;



import com.edu.ctbu.demo.service.CastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;



@Controller
public class CastController {

    @Autowired
    CastService castService;

    @RequestMapping("/information/Members/castlist")
    public String cast(){

        return "/information/Members/castlist";
    }
}
