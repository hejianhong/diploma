package com.edu.ctbu.demo.service;


import com.edu.ctbu.demo.domain.Employees;
import com.edu.ctbu.demo.domain.Members;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MembersService {

    List<Members> finAll();

    Page<Members> findAll(Pageable pageable);

    public Page<Members> findAll(Example<Members> members, Pageable pageable);

    public List<Members> findByMembername(String membername);

    Members insert(Members members);

    Members update(Members members);

    void delete(Members members);

    void delete(Long id);

    Members getById(Long id);
}
