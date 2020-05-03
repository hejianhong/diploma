package com.edu.ctbu.demo.dao;

import com.edu.ctbu.demo.domain.Petrolsales;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetrolsalesRepository extends JpaRepository<Petrolsales, Long> {
}
