package com.edu.ctbu.demo.domain;

import lombok.Data;

import javax.annotation.sql.DataSourceDefinition;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.criteria.CriteriaBuilder;

@Entity(name = "employees")
@Data
public class Employees {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private long id;

    private String name;

    private Integer gender;

    private Integer contactphonenumber;

    private String shift;

    private String homeaddress;

    private String dateofregistration;

    private String note;

    private Integer number;

    private String password;

}
