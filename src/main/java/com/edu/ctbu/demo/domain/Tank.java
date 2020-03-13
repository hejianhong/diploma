package com.edu.ctbu.demo.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "tank")
@Data
public class Tank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nameoftank;//油罐名称

    private String product;//油品名称

    private String categories;//油品种类

    private Float Inventorytonnage;//库存吨数

    private String Conversionratio;//转换比例

    private Float Inventoryfloor;//库存下限

    private Float Stockupseveral;//库存升数

    private Float retailprice;//零售价格

    private String note;//

    private String Dateregistration;//登记日期
}
