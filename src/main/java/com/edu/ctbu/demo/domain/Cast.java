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

    private String nameoftank;//油罐名称

    private String product;//油品名称

    private Double numberof;//数量

    private Double unitprice;//单价

    private Double receivableamount;//应收金额

    private Double paidin;//实收金额

    private String comeontime;//加油时间

    private String termsofpayment;//付款方式

    private Double cumulative;//累积消费

}
