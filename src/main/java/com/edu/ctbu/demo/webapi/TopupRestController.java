package com.edu.ctbu.demo.webapi;


import com.edu.ctbu.demo.core.PageUtils;
import com.edu.ctbu.demo.domain.Cast;
import com.edu.ctbu.demo.domain.Topup;
import com.edu.ctbu.demo.service.TopupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webapi/topup")
public class TopupRestController {

    @Autowired
    private TopupService topupService;

    @GetMapping("/list")
    public List<Topup> getAll(){

        List<Topup> topups = topupService.findAll();

        return topups;
    }

    @GetMapping("/getbypagecardnumber")
    public PageUtils getByPagecardnumber(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size,
                                         @RequestParam(value = "nameoftank", defaultValue = "") String nameoftank,
                                         @RequestParam(value = "cardnumber", defaultValue = "") Long cardnumber) {

        //按照id排序
        Sort sort = Sort.by(Sort.Direction.DESC, "id");

        Page<Topup> topupPage;

        if (StringUtils.isEmpty(cardnumber)) {

            Pageable pageable = PageRequest.of(page, size, sort);

            topupPage = topupService.findAll(pageable);

        } else {

            Topup topup = new Topup();

            topup.setCardnumber(cardnumber);

            Pageable pageable = PageRequest.of(page, size, sort);

            ExampleMatcher matcher = ExampleMatcher.matching()

                    .withMatcher("cardnumber", ExampleMatcher.GenericPropertyMatchers.contains());

            Example<Topup> example = Example.of(topup, matcher);

            topupPage = topupService.findAll(example, pageable);
        }

        PageUtils pageUtils = new PageUtils(topupPage.getContent(), topupPage.getTotalElements());

        return pageUtils;
    }

    @PostMapping("/insert")
    public Topup insert(Topup topup){

        Topup topup1 = topupService.insert(topup);

        return topup1;
    }

}
