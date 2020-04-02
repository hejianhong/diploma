package com.edu.ctbu.demo.dao;

import com.edu.ctbu.demo.domain.Tank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TankRepository extends JpaRepository<Tank,Long> {

    public Tank findByNameoftank(String nameoftank);

    public List<Tank> findByProduct(String product);

}