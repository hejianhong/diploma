package com.edu.ctbu.demo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "profitanalysis")
@Data
public class Profitanalysis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String petrolname;

    private Double feedcost;

    private Double salestotal;

    private Double salesprofit;
}
