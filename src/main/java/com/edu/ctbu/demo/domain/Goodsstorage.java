package com.edu.ctbu.demo.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;

@Entity(name = "goodsstorage")
@Data
public class Goodsstorage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String goodsname;

    private Double inprice;

    private Double salesprice;

    private Integer salesamount;

    private Integer inamount;

    private Integer outamount;

    private Integer extantamount;

    private Date indate;

    private Date outdate;

    private String suppliers;

    private String outreason;
}