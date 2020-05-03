package com.edu.ctbu.demo.controller;

import com.edu.ctbu.demo.domain.Petrolstorage;
import com.edu.ctbu.demo.service.PetrolstorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class PetrolstorageController {
    @Autowired
    PetrolstorageService petrolstorageService;

    @RequestMapping("/Petrolstorage/storage")
    public String list(HttpServletRequest httprequest, Model model) {

        HttpSession session = httprequest.getSession();

        if (session.getAttribute("userid") == null) {

            return "redirect:/login/login";
        }

        List<Petrolstorage> petrolstorages = petrolstorageService.findAll();
        model.addAttribute("data", petrolstorages);
        return "/Petrolstorage/storage";
    }
}