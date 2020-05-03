package com.edu.ctbu.demo.controller;

import com.edu.ctbu.demo.domain.Goodsprofits;
import com.edu.ctbu.demo.service.GoodsprofitsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GoodsprofitsController {
    @Autowired
    GoodsprofitsService goodsprofitsService;

    @RequestMapping("/Goodsprofits/gprofits")
    public String list(HttpServletRequest httprequest, Model model) {

        HttpSession session = httprequest.getSession();

        if (session.getAttribute("userid") == null) {

            return "redirect:/login/login";
        }
        List<Goodsprofits> goodsprofitss = goodsprofitsService.findAll();
        model.addAttribute("data", goodsprofitss);
        return "/Goodsprofits/gprofits";
    }
}
