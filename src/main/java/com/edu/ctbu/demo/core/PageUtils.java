package com.edu.ctbu.demo.core;


import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class PageUtils implements Serializable {


    private static final long serialVersionUID = 1L;

    private int total;

    private List<?> rows;


    public PageUtils(List<?> list, Long total){

        this.rows =list;

        this.total = total.intValue();
    }

    public PageUtils(List<?> list, int total){

        this.rows = list;

        this.total = total;
    }
}
