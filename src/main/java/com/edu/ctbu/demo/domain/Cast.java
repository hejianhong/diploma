package com.edu.ctbu.demo.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "cast")
@Data

public class Cast {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private Long cardnumber;

    private String lplatenumber;//车牌号码

    private Float kaneamount;//卡内金额

    private Float topupamount;//充值金额

    private String topupdate;//充值日期

    private String nameoftank;//油罐名称

    private String product;//油品名称

    private Float numberof;//数量

    private Float unitprice;//单价

    private Float receivableamount;//应收金额

    private Float paidin;//实收金额

    private String termsofpayment;//付款方式
}
