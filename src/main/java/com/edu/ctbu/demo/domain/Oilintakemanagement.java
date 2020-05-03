package com.edu.ctbu.demo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity(name = "oilintakemanagement")
@Data
public class Oilintakemanagement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ordernumber;

    private String tankname;

    private String petrolname;

    private Double lossratio;

    private Date feedtime;

    private Double feedtons;

    private Double feedlitres;

    private Double inprice;

    private Double feedamount;

    private Double actualtons;

    private Double actuallitres;

    private String handler;

    private String supplier;

    private String note;

}
