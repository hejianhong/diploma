package com.edu.ctbu.demo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity(name = "petrolsales")
@Data
public class Petrolsales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cardnumber;

    private String name;

    private String carnumber;

    private Double cardremaining;

    private Date salesdate;

    private String company;

    private String petrolname;

    private Double oilprice;

    private String oilgun;

    private String pumpstartcode;

    private String pumpstopcode;

    private Double salesamount;

    private Double receivableamount;

    private Double discountamount;

    private Double paidamount;

    private String payway;

    private String operator;

    private String note;

}
