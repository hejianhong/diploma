package com.edu.ctbu.demo.webapi;


import com.edu.ctbu.demo.domain.Tank;
import com.edu.ctbu.demo.service.TankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/webapi/tank")
public class TankRestController {

    @Autowired
    private TankService tankService;

    @GetMapping("/list")
    public List<Tank> getAll(){

        List<Tank> tank = tankService.findAll();

        return tank;
    }
}
