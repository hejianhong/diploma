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

    private Float originalamount;//原始金额

    private String Lplatenumber;//车牌号码

    private String Vehicletype;//车辆类型

    private String Vehicletypel;//车辆型号

    private String phonenumber;

    private String entity;//单位名称

    private String carddate;//办卡日期

    private String address;

    private String note;

    private Float Kaneamount;//卡内金额

    private Float Topupamount;//充值金额

    private String Topupdate;//充值日期

    private String product;//油品名称

    private Float numberof;//数量

    private Float unitprice;//单价

    private Float receivableamount;//应收金额

    private Float Paidin;//实收金额

    private String Termsofpayment;//付款方式

}
