package com.edu.ctbu.demo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "goodsprofits")
@Data
public class Goodsprofits {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String goodsname;

    private Double salesprice;

    private Integer salesamount;

    private Double inprice;

    private Double netprofits;

}
