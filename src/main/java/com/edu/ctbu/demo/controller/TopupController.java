package com.edu.ctbu.demo.controller;


import com.edu.ctbu.demo.service.TopupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TopupController {

    @Autowired
    TopupService topupService;

    @RequestMapping("/information/Members/topup")
    public String topup(){

        return "information/Members/topup";
    }
}
