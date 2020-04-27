package com.edu.ctbu.demo.controller;


import com.edu.ctbu.demo.domain.Supplier;
import com.edu.ctbu.demo.domain.Tank;
import com.edu.ctbu.demo.service.TankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class TankController {

    @Autowired
    TankService tankService;

    @RequestMapping("/information/Tank/tanklist")
    public String tank(HttpServletRequest httprequest, Model model){

        HttpSession session = httprequest.getSession();

        if (session.getAttribute("userid") == null) {

            return "redirect:/login/login";
        }

        List<Tank> tanks = tankService.findAll();

        model.addAttribute("data", tanks);

        return "information/Tank/tanklist";
    }
}
