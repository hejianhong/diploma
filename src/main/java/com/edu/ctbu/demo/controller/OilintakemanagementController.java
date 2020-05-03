package com.edu.ctbu.demo.controller;

import com.edu.ctbu.demo.domain.Oilintakemanagement;
import com.edu.ctbu.demo.service.OilintakemanagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class OilintakemanagementController {
    @Autowired
    OilintakemanagementService oilintakemanagementService;

    @RequestMapping("/Oilintakemanagement/management")
    public String list(HttpServletRequest httprequest, Model model) {

        HttpSession session = httprequest.getSession();

        if (session.getAttribute("userid") == null) {

            return "redirect:/login/login";
        }
        List<Oilintakemanagement> oilintakemanagements = oilintakemanagementService.findAll();
        model.addAttribute("data", oilintakemanagements);
        return "/Oilintakemanagement/management";
    }
}
