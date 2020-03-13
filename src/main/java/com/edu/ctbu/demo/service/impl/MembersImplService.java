package com.edu.ctbu.demo.service.impl;


import com.edu.ctbu.demo.domain.Members;
import com.edu.ctbu.demo.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembersImplService implements MembersService {

    @Autowired
    MembersService membersService;

    public List<Members> finAll() {

        return membersService.finAll();
    }
}
