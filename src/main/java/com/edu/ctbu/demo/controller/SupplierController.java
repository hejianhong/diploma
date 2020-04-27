package com.edu.ctbu.demo.controller;


import com.edu.ctbu.demo.domain.Members;
import com.edu.ctbu.demo.domain.Supplier;
import com.edu.ctbu.demo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @RequestMapping("/information/Supplier/supplierlist")
    public String supplier(HttpServletRequest httprequest, Model model){

        HttpSession session = httprequest.getSession();

        if (session.getAttribute("userid") == null) {

            return "redirect:/login/login";
        }

        List<Supplier> suppliers = supplierService.finAll();

        model.addAttribute("data", suppliers);

        return "information/Supplier/supplierlist";
    }
}
