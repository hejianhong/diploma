package com.edu.ctbu.demo.controller;

import com.edu.ctbu.demo.service.GoodssalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class billController {
    @Autowired
    GoodssalesService goodssalesService;

    @RequestMapping("/billmenu/bill")
    public String list() {
        return "/billmenu/bill";
    }
}
