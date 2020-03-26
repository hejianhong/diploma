package com.edu.ctbu.demo.dao;

import com.edu.ctbu.demo.domain.Members;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MembersRepository extends JpaRepository<Members,Long> {

    public List<Members> findByMembername(String membername);

    public List<Members> findByCardnumber(String cardnumber);

}
