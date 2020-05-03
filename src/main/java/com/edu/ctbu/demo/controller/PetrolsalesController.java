package com.edu.ctbu.demo.controller;

import com.edu.ctbu.demo.domain.Petrolsales;
import com.edu.ctbu.demo.service.PetrolsalesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PetrolsalesController {
    @Autowired
    PetrolsalesService petrolsalesService;

    @RequestMapping("/Petrolsales/sales")
    public String list(HttpServletRequest httprequest, Model model) {

        HttpSession session = httprequest.getSession();

        if (session.getAttribute("userid") == null) {

            return "redirect:/login/login";
        }
        List<Petrolsales> petrolsaless = petrolsalesService.findAll();
        model.addAttribute("data", petrolsaless);
        return "/Petrolsales/sales";
    }
}
