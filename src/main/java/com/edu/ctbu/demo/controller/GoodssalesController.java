package com.edu.ctbu.demo.controller;

import com.edu.ctbu.demo.domain.Goodssales;
import com.edu.ctbu.demo.service.GoodssalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GoodssalesController {
    @Autowired
    GoodssalesService goodssalesService;

    @RequestMapping("/Goodssales/gsales")
    public String list(HttpServletRequest httprequest, Model model) {

        HttpSession session = httprequest.getSession();

        if (session.getAttribute("userid") == null) {

            return "redirect:/login/login";
        }
        List<Goodssales> goodssaless = goodssalesService.findAll();
        model.addAttribute("data", goodssaless);
        return "/Goodssales/gsales";
    }
}
