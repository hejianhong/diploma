package com.edu.ctbu.demo.webapi;


import com.edu.ctbu.demo.core.PageUtils;
import com.edu.ctbu.demo.domain.Employees;
import com.edu.ctbu.demo.domain.Supplier;
import com.edu.ctbu.demo.domain.Tank;
import com.edu.ctbu.demo.service.TankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

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

    /**
     *分页读取
     */
    @GetMapping("/getbypage")
    public PageUtils getByPage(@RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "size", defaultValue = "10") Integer size,
                               @RequestParam(value = "nameoftank", defaultValue = "") String nameoftank,
                               @RequestParam(value = "product", defaultValue = "") String product){

        //按照id排序
        Sort sort = Sort.by(Sort.Direction.DESC,"id");

        Page<Tank> tankPage;

        if (StringUtils.isEmpty(product)){

            Pageable pageable = PageRequest.of(page,size,sort);

            tankPage = tankService.findAll(pageable);

        }else {

            Tank tank = new Tank();

            tank.setProduct(product);

            Pageable pageable = PageRequest.of(page,size,sort);

            ExampleMatcher matcher = ExampleMatcher.matching()

                    .withMatcher("product",ExampleMatcher.GenericPropertyMatchers.contains());

            Example<Tank> example = Example.of(tank,matcher);

            tankPage = tankService.findAll(example,pageable);
        }

        PageUtils pageUtils = new PageUtils(tankPage.getContent(),tankPage.getTotalElements());

        return pageUtils;
    }


    @GetMapping("/getbypageproduct")
    public PageUtils getByPageGender(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                     @RequestParam(value = "size", defaultValue = "10") Integer size,
                                     @RequestParam(value = "nameoftank", defaultValue = "") String nameoftank,
                                     @RequestParam(value = "product", defaultValue = "") String product){

        //按照id排序
        Sort sort = Sort.by(Sort.Direction.DESC,"id");

        Page<Tank> tankPage;

        if (StringUtils.isEmpty(nameoftank)){

            Pageable pageable = PageRequest.of(page,size,sort);

            tankPage = tankService.findAll(pageable);

        }else {

            Tank tank = new Tank();

            tank.setNameoftank(nameoftank);

            Pageable pageable = PageRequest.of(page,size,sort);

            ExampleMatcher matcher = ExampleMatcher.matching()

                    .withMatcher("nameoftank",ExampleMatcher.GenericPropertyMatchers.contains());

            Example<Tank> example = Example.of(tank,matcher);

            tankPage = tankService.findAll(example,pageable);
        }

        PageUtils pageUtils = new PageUtils(tankPage.getContent(),tankPage.getTotalElements());

        return pageUtils;
    }

    @GetMapping("/get/{id}")
    public Tank get(@PathVariable Long id){

        Tank tank=tankService.getById(id);

//        members.setPassword("");

        return tank;
    }

    @PostMapping("/insert")
    public Tank insert(Tank tank){

        Tank tank1=tankService.insert(tank);

        return tank1;

    }

    @PutMapping("/update")
    public Tank update(Tank tank){

        Tank oldtank=tankService.getById(tank.getId());

        if(StringUtils.isEmpty(tank.getNameoftank())){

            tank.setNameoftank(oldtank.getNameoftank());
        }

        tank=tankService.update(tank);

        return tank;

    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){

        tankService.delete(id);

    }
}
