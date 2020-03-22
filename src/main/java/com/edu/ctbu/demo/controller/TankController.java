package com.edu.ctbu.demo.controller;


import com.edu.ctbu.demo.service.TankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TankController {

    @Autowired
    TankService tankService;

    @RequestMapping("/information/Tank/tanklist")
    public String tank(){

        return "/information/Tank/tanklist";
    }
}
