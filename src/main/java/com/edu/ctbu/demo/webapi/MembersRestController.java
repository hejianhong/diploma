package com.edu.ctbu.demo.webapi;


import com.edu.ctbu.demo.core.PageUtils;
import com.edu.ctbu.demo.domain.Employees;
import com.edu.ctbu.demo.domain.Members;
import com.edu.ctbu.demo.service.MembersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/getbypagecard")
    public PageUtils getByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "size", defaultValue = "10") Integer size,
                               @RequestParam(value = "membername", defaultValue = "") String membername,
                               @RequestParam(value = "gender", defaultValue = "") Integer gender,
                               @RequestParam(value = "cardnumber", defaultValue = "") Long cardnumber) {

        //按照id排序
        Sort sort = Sort.by(Sort.Direction.DESC, "id");

        Page<Members> membersPage;

        if (StringUtils.isEmpty(gender)) {

            Pageable pageable = PageRequest.of(page, size, sort);

            membersPage = membersService.findAll(pageable);

        } else {

            Members members = new Members();

            members.setGender(Math.toIntExact(cardnumber));

            Pageable pageable = PageRequest.of(page, size, sort);

            ExampleMatcher matcher = ExampleMatcher.matching()

                    .withMatcher("cardnumber", ExampleMatcher.GenericPropertyMatchers.contains());

            Example<Members> example = Example.of(members, matcher);

            membersPage = membersService.findAll(example, pageable);
        }

        PageUtils pageUtils = new PageUtils(membersPage.getContent(), membersPage.getTotalElements());

        return pageUtils;
    }


    @GetMapping("/getbypageisvip")
    public PageUtils getByPageIsvip(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                     @RequestParam(value = "size", defaultValue = "10") Integer size,
                                     @RequestParam(value = "membername", defaultValue = "") String membername,
                                     @RequestParam(value = "isvip", defaultValue = "") Integer isvip) {

        //按照id排序
        Sort sort = Sort.by(Sort.Direction.DESC, "id");

        Page<Members> membersPage;

        if (StringUtils.isEmpty(isvip)) {

            Pageable pageable = PageRequest.of(page, size, sort);

            membersPage = membersService.findAll(pageable);

        } else {

            Members members = new Members();

            members.setIsvip(isvip);

            Pageable pageable = PageRequest.of(page, size, sort);

            ExampleMatcher matcher = ExampleMatcher.matching()

                    .withMatcher("isvip", ExampleMatcher.GenericPropertyMatchers.contains());

            Example<Members> example = Example.of(members, matcher);

            membersPage = membersService.findAll(example, pageable);
        }

        PageUtils pageUtils = new PageUtils(membersPage.getContent(), membersPage.getTotalElements());

        return pageUtils;
    }

    @GetMapping("/getbypagemembername")
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

    @GetMapping("/get/{id}")
    public Members get(@PathVariable Long id){

        Members members=membersService.getById(id);

//        members.setPassword("");

        return members;
    }

    @PostMapping("/insert")
    public Members insert(Members members){

        Members members1=membersService.insert(members);

        return members1;

    }

    @PutMapping("/update")
    public Members update(Members members){

        Members oldmembers=membersService.getById(members.getId());

        if(StringUtils.isEmpty(members.getMembername())){

            members.setMembername(oldmembers.getMembername());
        }

        members=membersService.update(members);

        return members;

    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){

        membersService.delete(id);

    }

    @GetMapping("/getby/{cardnumber}")
    public Members getby(@PathVariable Long cardnumber){

        Members members = membersService.findByCardnumber(cardnumber);

        return members;
    }
}
