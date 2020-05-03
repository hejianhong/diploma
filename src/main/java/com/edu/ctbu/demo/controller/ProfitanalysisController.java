package com.edu.ctbu.demo.controller;

import com.edu.ctbu.demo.domain.Profitanalysis;
import com.edu.ctbu.demo.service.ProfitanalysisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class ProfitanalysisController {
    @Autowired
    ProfitanalysisService profitanalysisService;

    @RequestMapping("/Profitanalysis/analysis")
    public String list(HttpServletRequest httprequest, Model model) {

        HttpSession session = httprequest.getSession();

        if (session.getAttribute("userid") == null) {

            return "redirect:/login/login";
        }

        List<Profitanalysis> profitanalysiss = profitanalysisService.findAll();
        model.addAttribute("data", profitanalysiss);
        return "/Profitanalysis/analysis";
    }
}
