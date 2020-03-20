package com.edu.ctbu.demo.service.impl;


import com.edu.ctbu.demo.dao.MembersRepository;
import com.edu.ctbu.demo.domain.Employees;
import com.edu.ctbu.demo.domain.Members;
import com.edu.ctbu.demo.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembersImplService implements MembersService {

    @Autowired
    MembersRepository membersRepository;

    public List<Members> finAll() {

        return membersRepository.findAll();
    }

    public Page<Members> findAll(Pageable pageable){

        return membersRepository.findAll(pageable);

    }

    public Page<Members> findAll(Example<Members> members , Pageable pageable){

        return membersRepository.findAll(members,pageable);
    }

    public List<Members> findByMembername(String membername){

        return membersRepository.findByMembername(membername);
    }

    public Members insert(Members members){

        return membersRepository.save(members);
    }

    public Members update(Members members){

        return membersRepository.save(members);
    }

    public void delete(Members members){

        membersRepository.delete(members);
    }

    public void delete(Long id){

        Members members = new Members();

        members.setId(id);

        membersRepository.delete(members);
    }

    public Members getById(Long id){

        return membersRepository.findById(id).orElse(null);
    }
}
