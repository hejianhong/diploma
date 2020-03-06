package com.edu.ctbu.demo.webapi;


import com.edu.ctbu.demo.domain.Employees;
import com.edu.ctbu.demo.service.EmployessService;
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
    EmployessService employessService;

    @GetMapping("/user")
    public int user(HttpServletRequest httpServletRequest , String name , String password){

        List<Employees> employees = employessService.findByNameAndPassword(name,password);

        //判断用户名密码是否存在

        if (employees.size() > 0){

            HttpSession session = httpServletRequest.getSession();

            session.setAttribute("userid",employees.get(0).getId());

            session.setAttribute("user",employees.get(0));

            return 1;
        }else {

            return -1;
        }
    }
}
