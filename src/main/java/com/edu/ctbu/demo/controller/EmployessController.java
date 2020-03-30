package com.edu.ctbu.demo.controller;


import com.edu.ctbu.demo.domain.Employees;
import com.edu.ctbu.demo.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class EmployessController {

    @Autowired
    EmployeesService employeesService;

    @RequestMapping("/information/Employees/employeeslist")
    public String employees(HttpServletRequest httprequest, Model model){

        HttpSession session = httprequest.getSession();

        if(session.getAttribute("userid")==null){

            return "redirect:/login/login";
        }


        List<Employees> employees = employeesService.findAll();

        model.addAttribute("data",employees);

        return "/information/Employees/employeeslist";
    }

    @RequestMapping("/information/qiandao/qiandao")
    public String qd(){

        return "information/qiandao/qiandao";
    }

    @RequestMapping("/information/qiandao/finishqd")
    public String finishqd(){

        return "information/qiandao/finishqd";
    }

    @RequestMapping("/information/Employees/shift")
    public String shift(){

        return "information/Employees/shift";
    }

}
