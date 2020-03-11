package com.edu.ctbu.demo.controller;


import com.edu.ctbu.demo.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MembersController {

    @Autowired
    MembersService membersService;
}
