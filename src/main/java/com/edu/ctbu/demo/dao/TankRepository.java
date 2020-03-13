package com.edu.ctbu.demo.dao;

import com.edu.ctbu.demo.domain.Tank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TankRepository extends JpaRepository<Tank,Long> {

    public List<Tank> findByNameoftank(String nameoftank);
}