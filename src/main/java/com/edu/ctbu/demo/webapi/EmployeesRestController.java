package com.edu.ctbu.demo.webapi;


import com.edu.ctbu.demo.core.PageUtils;
import com.edu.ctbu.demo.domain.Employees;
import com.edu.ctbu.demo.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webapi/employees")
public class EmployeesRestController {


    @Autowired
    private EmployeesService employeesService;

    @GetMapping("/list")
    public List<Employees> getAll(){

        List<Employees> employees =employeesService.findAll();

        return employees;
    }


    /**
     *分页读取
     */
    @GetMapping("/getbypage")
    public PageUtils getByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "size", defaultValue = "10") Integer size,
                               @RequestParam(value = "name", defaultValue = "") String name,
                               @RequestParam(value = "gender", defaultValue = "") Integer gender){

        //按照id排序
        Sort sort = Sort.by(Sort.Direction.DESC,"id");

        Page<Employees> employeesPage;

        if (StringUtils.isEmpty(gender)){

            Pageable pageable = PageRequest.of(page,size,sort);

            employeesPage = employeesService.findAll(pageable);

        }else {

            Employees employees = new Employees();

            employees.setGender(gender);

            Pageable pageable = PageRequest.of(page,size,sort);

            ExampleMatcher matcher = ExampleMatcher.matching()

                    .withMatcher("gender",ExampleMatcher.GenericPropertyMatchers.contains());

            Example<Employees> example = Example.of(employees,matcher);

            employeesPage = employeesService.findAll(example,pageable);
        }

        PageUtils pageUtils = new PageUtils(employeesPage.getContent(),employeesPage.getTotalElements());

        return pageUtils;
    }


    @GetMapping("/getbypagenumber")
    public PageUtils getByPageGender(@RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "size", defaultValue = "10") Integer size,
                               @RequestParam(value = "name", defaultValue = "") String name,
                               @RequestParam(value = "gender", defaultValue = "") Integer gender,
                               @RequestParam(value = "number", defaultValue = "") String number){

        //按照id排序
        Sort sort = Sort.by(Sort.Direction.DESC,"id");

        Page<Employees> employeesPage;

        if (StringUtils.isEmpty(number)){

            Pageable pageable = PageRequest.of(page,size,sort);

            employeesPage = employeesService.findAll(pageable);

        }else {

            Employees employees = new Employees();

            employees.setName(number);

            Pageable pageable = PageRequest.of(page,size,sort);

            ExampleMatcher matcher = ExampleMatcher.matching()

                    .withMatcher("number",ExampleMatcher.GenericPropertyMatchers.contains());

            Example<Employees> example = Example.of(employees,matcher);

            employeesPage = employeesService.findAll(example,pageable);
        }

        PageUtils pageUtils = new PageUtils(employeesPage.getContent(),employeesPage.getTotalElements());

        return pageUtils;
    }

    @GetMapping("/getbypagename")
    public PageUtils getByPageGender(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                     @RequestParam(value = "size", defaultValue = "10") Integer size,
                                     @RequestParam(value = "name", defaultValue = "") String name,
                                     @RequestParam(value = "gender", defaultValue = "") Integer gender){

        //按照id排序
        Sort sort = Sort.by(Sort.Direction.DESC,"id");

        Page<Employees> employeesPage;

        if (StringUtils.isEmpty(name)){

            Pageable pageable = PageRequest.of(page,size,sort);

            employeesPage = employeesService.findAll(pageable);

        }else {

            Employees employees = new Employees();

            employees.setName(name);

            Pageable pageable = PageRequest.of(page,size,sort);

            ExampleMatcher matcher = ExampleMatcher.matching()

                    .withMatcher("name",ExampleMatcher.GenericPropertyMatchers.contains());

            Example<Employees> example = Example.of(employees,matcher);

            employeesPage = employeesService.findAll(example,pageable);
        }

        PageUtils pageUtils = new PageUtils(employeesPage.getContent(),employeesPage.getTotalElements());

        return pageUtils;
    }

    @GetMapping("/get/{id}")
    public Employees get(@PathVariable Long id){

        Employees employees=employeesService.getById(id);

        employees.setPassword("");

        return employees;
    }

    @GetMapping("getby/{number}")
    public Employees getby(@PathVariable Long number){

        Employees employees = employeesService.finByNumber(number);


        return employees;
    }

    @PostMapping("/insert")
    public Employees insert(Employees employees){

        Employees employees1=employeesService.insert(employees);

        return employees1;

    }

    @PutMapping("/update")
    public Employees update(Employees employees){

        Employees oldemployees=employeesService.getById(employees.getId());

        if(StringUtils.isEmpty(employees.getName())){

            employees.setName(oldemployees.getName());
        }

        employees=employeesService.update(employees);

        return employees;

    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){

        employeesService.delete(id);

    }
}
