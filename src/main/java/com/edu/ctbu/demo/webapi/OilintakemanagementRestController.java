package com.edu.ctbu.demo.webapi;

import com.edu.ctbu.demo.core.PageUtils;
import com.edu.ctbu.demo.domain.Oilintakemanagement;
import com.edu.ctbu.demo.service.OilintakemanagementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webAPI/Oilintakemanagement")
public class OilintakemanagementRestController {
    @Autowired
    private OilintakemanagementService oilintakemanagementService;

    Pageable pageable;

    @GetMapping("/list")
    public List<Oilintakemanagement> getAll() {

        List<Oilintakemanagement> oilintakemanagements = oilintakemanagementService.findAll();
        return oilintakemanagements;
    }
    @GetMapping("/search")
    public PageUtils search(@RequestParam(value = "page", defaultValue = "0") Integer page,
                            @RequestParam(value = "size", defaultValue = "10") Integer size,
                            @RequestParam(value = "TankName", defaultValue = "") String TankName,
                            @RequestParam(value = "PetrolName", defaultValue = "") String PetrolName,
                            @RequestParam(value = "order", defaultValue = "") String order,
                            @RequestParam(value = "handler", defaultValue = "") String handler,
                            @RequestParam(value = "supplier", defaultValue = "") String supplier) {
        Sort sort = Sort.by(Sort.Direction.ASC, "id");

        Page<Oilintakemanagement> oilintakemanagementPage = null;
        if(StringUtils.isEmpty(TankName)&&StringUtils.isEmpty(PetrolName)&&StringUtils.isEmpty(order)//查询条件全空
                &&StringUtils.isEmpty(handler)&&StringUtils.isEmpty(supplier)){
            Pageable pageable = PageRequest.of(page, size, sort);
            oilintakemanagementPage=oilintakemanagementService.findAll(pageable);
        }else if(!(StringUtils.isEmpty(TankName))&&StringUtils.isEmpty(PetrolName)&&StringUtils.isEmpty(order)//只对油罐名称
                &&StringUtils.isEmpty(handler)&&StringUtils.isEmpty(supplier)){
            Oilintakemanagement oilintakemanagement=new Oilintakemanagement();
            oilintakemanagement.setTankname(TankName);
            Pageable pageable=PageRequest.of(page,size,sort);
            ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("TankName",ExampleMatcher.GenericPropertyMatchers.contains());
            Example<Oilintakemanagement> example=Example.of(oilintakemanagement,matcher);
            oilintakemanagementPage=oilintakemanagementService.findAll(example,pageable);
        }else if(!(StringUtils.isEmpty(PetrolName))&&StringUtils.isEmpty(TankName)&&StringUtils.isEmpty(order)//只对油品名称
                &&StringUtils.isEmpty(handler)&&StringUtils.isEmpty(supplier)){
            Oilintakemanagement oilintakemanagement=new Oilintakemanagement();
            oilintakemanagement.setPetrolname(PetrolName);
            Pageable pageable=PageRequest.of(page,size,sort);
            ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("PetrolName",ExampleMatcher.GenericPropertyMatchers.contains());
            Example<Oilintakemanagement> example=Example.of(oilintakemanagement,matcher);
            oilintakemanagementPage=oilintakemanagementService.findAll(example,pageable);
        }else if(!(StringUtils.isEmpty(order))&&StringUtils.isEmpty(PetrolName)&&StringUtils.isEmpty(TankName)//只对进油单号
                &&StringUtils.isEmpty(handler)&&StringUtils.isEmpty(supplier)){
            Oilintakemanagement oilintakemanagement=new Oilintakemanagement();
            oilintakemanagement.setOrdernumber(order);
            Pageable pageable=PageRequest.of(page,size,sort);
            ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("order",ExampleMatcher.GenericPropertyMatchers.exact());
            Example<Oilintakemanagement> example=Example.of(oilintakemanagement,matcher);
            oilintakemanagementPage=oilintakemanagementService.findAll(example,pageable);
        }else if(!(StringUtils.isEmpty(handler))&&StringUtils.isEmpty(PetrolName)&&StringUtils.isEmpty(order)//只对经手人
                &&StringUtils.isEmpty(TankName)&&StringUtils.isEmpty(supplier)){
            Oilintakemanagement oilintakemanagement=new Oilintakemanagement();
            oilintakemanagement.setHandler(handler);
            Pageable pageable=PageRequest.of(page,size,sort);
            ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("handler",ExampleMatcher.GenericPropertyMatchers.contains());
            Example<Oilintakemanagement> example=Example.of(oilintakemanagement,matcher);
            oilintakemanagementPage=oilintakemanagementService.findAll(example,pageable);
        }else if(!(StringUtils.isEmpty(supplier))&&StringUtils.isEmpty(PetrolName)&&StringUtils.isEmpty(order)//只对供应商
                &&StringUtils.isEmpty(handler)&&StringUtils.isEmpty(TankName)){
            Oilintakemanagement oilintakemanagement=new Oilintakemanagement();
            oilintakemanagement.setSupplier(supplier);
            Pageable pageable=PageRequest.of(page,size,sort);
            ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("supplier",ExampleMatcher.GenericPropertyMatchers.contains());
            Example<Oilintakemanagement> example=Example.of(oilintakemanagement,matcher);
            oilintakemanagementPage=oilintakemanagementService.findAll(example,pageable);
        }else if(!(StringUtils.isEmpty(TankName))&&!(StringUtils.isEmpty(PetrolName))&&StringUtils.isEmpty(order)//油罐名称和油品名称组合
                &&StringUtils.isEmpty(handler)&&StringUtils.isEmpty(supplier)){
            Oilintakemanagement oilintakemanagement=new Oilintakemanagement();
            oilintakemanagement.setTankname(TankName);
            oilintakemanagement.setPetrolname(PetrolName);
            Pageable pageable=PageRequest.of(page,size,sort);
            ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("TankName",ExampleMatcher.GenericPropertyMatchers.contains())
                    .withMatcher("PetrolName",ExampleMatcher.GenericPropertyMatchers.contains());
            Example<Oilintakemanagement> example=Example.of(oilintakemanagement,matcher);
            oilintakemanagementPage=oilintakemanagementService.findAll(example,pageable);
        }else if(!(StringUtils.isEmpty(TankName))&&!(StringUtils.isEmpty(PetrolName))&&!(StringUtils.isEmpty(order))//油罐名称和油品名称和进油单号组合
                &&StringUtils.isEmpty(handler)&&StringUtils.isEmpty(supplier)){
            Oilintakemanagement oilintakemanagement=new Oilintakemanagement();
            oilintakemanagement.setTankname(TankName);
            oilintakemanagement.setPetrolname(PetrolName);
            oilintakemanagement.setOrdernumber(order);
            Pageable pageable=PageRequest.of(page,size,sort);
            ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("TankName",ExampleMatcher.GenericPropertyMatchers.contains())
                    .withMatcher("PetrolName",ExampleMatcher.GenericPropertyMatchers.contains())
                    .withMatcher("order",ExampleMatcher.GenericPropertyMatchers.exact());
            Example<Oilintakemanagement> example=Example.of(oilintakemanagement,matcher);
            oilintakemanagementPage=oilintakemanagementService.findAll(example,pageable);
        }else if(!(StringUtils.isEmpty(TankName))&&!(StringUtils.isEmpty(PetrolName))&&!(StringUtils.isEmpty(handler))//油罐名称和油品名称和经手人
                &&StringUtils.isEmpty(order)&&StringUtils.isEmpty(supplier)){
            Oilintakemanagement oilintakemanagement=new Oilintakemanagement();
            oilintakemanagement.setTankname(TankName);
            oilintakemanagement.setPetrolname(PetrolName);
            oilintakemanagement.setHandler(handler);
            Pageable pageable=PageRequest.of(page,size,sort);
            ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("TankName",ExampleMatcher.GenericPropertyMatchers.contains())
                    .withMatcher("PetrolName",ExampleMatcher.GenericPropertyMatchers.contains())
                    .withMatcher("handler",ExampleMatcher.GenericPropertyMatchers.exact());
            Example<Oilintakemanagement> example=Example.of(oilintakemanagement,matcher);
            oilintakemanagementPage=oilintakemanagementService.findAll(example,pageable);
        }else if(!(StringUtils.isEmpty(TankName))&&!(StringUtils.isEmpty(PetrolName))&&!(StringUtils.isEmpty(supplier))//油罐名称和油品名称和供货商
                &&StringUtils.isEmpty(order)&&StringUtils.isEmpty(handler)){
            Oilintakemanagement oilintakemanagement=new Oilintakemanagement();
            oilintakemanagement.setTankname(TankName);
            oilintakemanagement.setPetrolname(PetrolName);
            oilintakemanagement.setSupplier(supplier);
            Pageable pageable=PageRequest.of(page,size,sort);
            ExampleMatcher matcher=ExampleMatcher.matching().withMatcher("TankName",ExampleMatcher.GenericPropertyMatchers.contains())
                    .withMatcher("PetrolName",ExampleMatcher.GenericPropertyMatchers.contains())
                    .withMatcher("supplier",ExampleMatcher.GenericPropertyMatchers.exact());
            Example<Oilintakemanagement> example=Example.of(oilintakemanagement,matcher);
            oilintakemanagementPage=oilintakemanagementService.findAll(example,pageable);
        }
        PageUtils PageUtils = new PageUtils(oilintakemanagementPage.getContent(), oilintakemanagementPage.getTotalElements());
        return PageUtils;
    }

    @PostMapping("/insert")
    public Oilintakemanagement insert(Oilintakemanagement oilintakemanagement) {
        Oilintakemanagement oilintakemanagement1=oilintakemanagementService.insert(oilintakemanagement);
        return oilintakemanagement1;
    }

    @PutMapping("/update")
    public Oilintakemanagement update(Oilintakemanagement oilintakemanagement) {
        oilintakemanagement = oilintakemanagementService.update(oilintakemanagement);
        return oilintakemanagement;
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        oilintakemanagementService.delete(id);
    }

    @DeleteMapping("/deletelist/{ids}")
    public Long deletelist(@PathVariable Long[] ids) {
        long count = 0;
        for (Long id : ids) {
            oilintakemanagementService.delete(id);
            count++;
        }
        return count;
    }

    @GetMapping("/get/{id}")
    public Oilintakemanagement get(@PathVariable Long id) {

        Oilintakemanagement oilintakemanagement = oilintakemanagementService.getById(id);
        return oilintakemanagement;
    }
}
