package com.edu.ctbu.demo.webapi;


import com.edu.ctbu.demo.domain.Members;
import com.edu.ctbu.demo.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/webapi/members")
public class MembersRestController {


    @Autowired
    private MembersService membersService;

    @GetMapping("/list")
    public List<Members> getAll(){

        List<Members> members = membersService.finAll();

        return members;
    }
}
