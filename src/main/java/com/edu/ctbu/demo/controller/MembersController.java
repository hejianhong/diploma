package com.edu.ctbu.demo.controller;


import com.edu.ctbu.demo.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MembersController {

    @Autowired
    MembersService membersService;

    @RequestMapping("/information/Members/memberslist")
    public String members(){

        return "/information/Members/memberslist";
    }
}
