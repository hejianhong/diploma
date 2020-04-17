package com.edu.ctbu.demo.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "members")
@Data
public class Members {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cardnumber;

    private String membername;

    private Integer gender;

    private String lplatenumber;//车牌号码

    private String vehicletype;//车辆类型

    private String vehicletypel;//车辆型号

    private String phonenumber;

    private String entity;//单位名称

    private String carddate;//办卡日期

    private String address;

    private String note;

    private Float initialamount;//当前余额

    private Integer isvip;

    private Float accumulatedtopup;//累积充值

}
