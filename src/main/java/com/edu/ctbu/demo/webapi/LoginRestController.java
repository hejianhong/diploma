package com.edu.ctbu.demo.webapi;


import com.edu.ctbu.demo.domain.Employees;
import com.edu.ctbu.demo.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping("/webapi/login")
public class LoginRestController {

    @Autowired
    EmployeesService employeesService;

    @GetMapping("/login")
    public int user(HttpServletRequest httprequest , String username , String password){

        List<Employees> employees = employeesService.findByNameAndPassword(username,password);



        //判断用户名密码是否存在

        if (employees.size()> 0){

            HttpSession session = httprequest.getSession();

            session.setAttribute("userid",employees.get(0).getId());

            session.setAttribute("user",employees.get(0));

            return 1;

        }else {

            return -1;
        }

    }
}
