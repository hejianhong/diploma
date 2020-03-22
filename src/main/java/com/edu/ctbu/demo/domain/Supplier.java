package com.edu.ctbu.demo.domain;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "supplier")
@Data
public class Supplier {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String name;

    private String address;

    private String thecontact;//联系人

    private String phone;

    private String fax;

    private String email;

    private String ein;//税号

    private String whereitis;//开户行

    private String note;

    private String dateregistration;//登记日期
}
