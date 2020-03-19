package com.edu.ctbu.demo.webapi;


import com.edu.ctbu.demo.core.PageUtils;
import com.edu.ctbu.demo.domain.Employees;
import com.edu.ctbu.demo.domain.Supplier;
import com.edu.ctbu.demo.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/webapi/supplier")
public class SupplierRestController {

    @Autowired
    private SupplierService supplierService;


    @GetMapping("/list")
    public List<Supplier> getAll(){

        List<Supplier> supplier = supplierService.finAll();

        return supplier;
    }

    /**
     *分页读取
     */
    @GetMapping("/getbypage")
    public PageUtils getByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "size", defaultValue = "10") Integer size,
                               @RequestParam(value = "name", defaultValue = "") String name,
                               @RequestParam(value = "address", defaultValue = "") String address){

        //按照id排序
        Sort sort = Sort.by(Sort.Direction.DESC,"id");

        Page<Supplier> supplierPage;

        if (StringUtils.isEmpty(address)){

            Pageable pageable = PageRequest.of(page,size,sort);

            supplierPage = supplierService.findAll(pageable);

        }else {

            Supplier supplier = new Supplier();

            supplier.setAddress(address);

            Pageable pageable = PageRequest.of(page,size,sort);

            ExampleMatcher matcher = ExampleMatcher.matching()

                    .withMatcher("address",ExampleMatcher.GenericPropertyMatchers.contains());

            Example<Supplier> example = Example.of(supplier,matcher);

            supplierPage = supplierService.findAll(example,pageable);
        }

        PageUtils pageUtils = new PageUtils(supplierPage.getContent(),supplierPage.getTotalElements());

        return pageUtils;
    }


    @GetMapping("/getbypageaddress")
    public PageUtils getByPageGender(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                     @RequestParam(value = "size", defaultValue = "10") Integer size,
                                     @RequestParam(value = "name", defaultValue = "") String name,
                                     @RequestParam(value = "address", defaultValue = "") String address){

        //按照id排序
        Sort sort = Sort.by(Sort.Direction.DESC,"id");

        Page<Supplier> supplierPage;

        if (StringUtils.isEmpty(name)){

            Pageable pageable = PageRequest.of(page,size,sort);

            supplierPage = supplierService.findAll(pageable);

        }else {

            Supplier supplier = new Supplier();

            supplier.setName(name);

            Pageable pageable = PageRequest.of(page,size,sort);

            ExampleMatcher matcher = ExampleMatcher.matching()

                    .withMatcher("name",ExampleMatcher.GenericPropertyMatchers.contains());

            Example<Supplier> example = Example.of(supplier,matcher);

            supplierPage = supplierService.findAll(example,pageable);
        }

        PageUtils pageUtils = new PageUtils(supplierPage.getContent(),supplierPage.getTotalElements());

        return pageUtils;
    }
}
