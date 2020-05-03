package com.edu.ctbu.demo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "petrolstorage")
@Data
public class Petrolstorage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String petrolname;

    private String tankname;

    private Double currentlitres;

    private Double inaccumulation;

    private Double outaccumulation;

    private Double oldlitres;

    private Double inprice;

    private Double salesprice;
}
