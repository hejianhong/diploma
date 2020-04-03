package com.edu.ctbu.demo.dao;

import com.edu.ctbu.demo.domain.Cast;
import com.edu.ctbu.demo.domain.Employees;
import com.edu.ctbu.demo.domain.Members;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;
import java.util.List;

public interface CastRepository  extends JpaRepository<Cast, Long> {


    public List<Cast> findByNameoftank(String nameoftank);

    public List<Cast> findByProduct(String product);

}
