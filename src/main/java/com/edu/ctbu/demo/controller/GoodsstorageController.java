package com.edu.ctbu.demo.controller;

import com.edu.ctbu.demo.domain.Goodsstorage;
import com.edu.ctbu.demo.service.GoodsstorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class GoodsstorageController {
    @Autowired
    GoodsstorageService goodsstorageService;

    @RequestMapping("/Goodsstorage/gstorage")
    public String list(HttpServletRequest httprequest, Model model) {

        HttpSession session = httprequest.getSession();

        if (session.getAttribute("userid") == null) {

            return "redirect:/login/login";
        }
        List<Goodsstorage> goodsstorages = goodsstorageService.findAll();
        model.addAttribute("data", goodsstorages);
        return "/Goodsstorage/gstorage";
    }
}
