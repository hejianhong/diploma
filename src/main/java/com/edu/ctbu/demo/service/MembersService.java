package com.edu.ctbu.demo.service;


import com.edu.ctbu.demo.domain.Members;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MembersService {

    List<Members> finAll();
}