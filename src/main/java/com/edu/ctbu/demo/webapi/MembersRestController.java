package com.edu.ctbu.demo.webapi;


import com.edu.ctbu.demo.core.PageUtils;
import com.edu.ctbu.demo.domain.Employees;
import com.edu.ctbu.demo.domain.Members;
import com.edu.ctbu.demo.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/webapi/members")
public class MembersRestController {


    @Autowired
    private MembersService membersService;

    @GetMapping("/list")
    public List<Members> getAll() {

        List<Members> members = membersService.finAll();

        return members;
    }

    /**
     * 分页读取
     */

    @GetMapping("/getbypage")
    public PageUtils getByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "size", defaultValue = "10") Integer size,
                               @RequestParam(value = "membername", defaultValue = "") String membername,
                               @RequestParam(value = "gender", defaultValue = "") Integer gender) {

        //按照id排序
        Sort sort = Sort.by(Sort.Direction.DESC, "id");

        Page<Members> membersPage;

        if (StringUtils.isEmpty(gender)) {

            Pageable pageable = PageRequest.of(page, size, sort);

            membersPage = membersService.findAll(pageable);

        } else {

            Members members = new Members();

            members.setGender(gender);

            Pageable pageable = PageRequest.of(page, size, sort);

            ExampleMatcher matcher = ExampleMatcher.matching()

                    .withMatcher("gender", ExampleMatcher.GenericPropertyMatchers.contains());

            Example<Members> example = Example.of(members, matcher);

            membersPage = membersService.findAll(example, pageable);
        }

        PageUtils pageUtils = new PageUtils(membersPage.getContent(), membersPage.getTotalElements());

        return pageUtils;
    }


    @GetMapping("/getbypagename")
    public PageUtils getByPageGender(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                     @RequestParam(value = "size", defaultValue = "10") Integer size,
                                     @RequestParam(value = "membername", defaultValue = "") String membername,
                                     @RequestParam(value = "gender", defaultValue = "") Integer gender) {

        //按照id排序
        Sort sort = Sort.by(Sort.Direction.DESC, "id");

        Page<Members> membersPage;

        if (StringUtils.isEmpty(membername)) {

            Pageable pageable = PageRequest.of(page, size, sort);

            membersPage = membersService.findAll(pageable);

        } else {

            Members members = new Members();

            members.setMembername(membername);

            Pageable pageable = PageRequest.of(page, size, sort);

            ExampleMatcher matcher = ExampleMatcher.matching()

                    .withMatcher("membername", ExampleMatcher.GenericPropertyMatchers.contains());

            Example<Members> example = Example.of(members, matcher);

            membersPage = membersService.findAll(example, pageable);
        }

        PageUtils pageUtils = new PageUtils(membersPage.getContent(), membersPage.getTotalElements());

        return pageUtils;
    }
}
