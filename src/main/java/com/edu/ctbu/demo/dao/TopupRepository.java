package com.edu.ctbu.demo.dao;

import com.edu.ctbu.demo.domain.Topup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TopupRepository extends JpaRepository<Topup,Long>{

    public List<Topup> findByCardnumber(Long cardnumber);

}
