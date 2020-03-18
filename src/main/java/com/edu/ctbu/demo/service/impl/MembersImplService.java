package com.edu.ctbu.demo.service.impl;


import com.edu.ctbu.demo.dao.MembersRepository;
import com.edu.ctbu.demo.domain.Members;
import com.edu.ctbu.demo.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembersImplService implements MembersService {

    @Autowired
    MembersRepository membersRepository;

    public List<Members> finAll() {

        return membersRepository.findAll();
    }
}
