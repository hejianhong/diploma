package com.edu.ctbu.demo.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "topup")
@Data
public class Topup {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private Long cardnumber;

    private Float originalamount;//原始金额

    private Float topupamount;//充值金额

    private String topupdate;//充值日期
}
