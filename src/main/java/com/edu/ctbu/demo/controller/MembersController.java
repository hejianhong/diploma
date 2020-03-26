package com.edu.ctbu.demo.controller;


import com.edu.ctbu.demo.domain.Employees;
import com.edu.ctbu.demo.domain.Members;
import com.edu.ctbu.demo.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class MembersController {

    @Autowired
    MembersService membersService;

    @RequestMapping("/information/Members/memberslist")
    public String members(HttpServletRequest httprequest, Model model) {

        HttpSession session = httprequest.getSession();

        if (session.getAttribute("userid") == null) {

            return "redirect:/login/login";
        }

        List<Members> members = membersService.finAll();

        model.addAttribute("data", members);

        return "/information/Members/memberslist";
    }

    @RequestMapping("information/Members/castlist")
    public String cast(HttpServletRequest httprequest, Model model){

        HttpSession session = httprequest.getSession();

        if (session.getAttribute("userid") == null) {

            return "redirect:/login/login";
        }

        List<Members> members = membersService.finAll();

        model.addAttribute("data", members);

        return "/information/Members/castlist";
    }
}
