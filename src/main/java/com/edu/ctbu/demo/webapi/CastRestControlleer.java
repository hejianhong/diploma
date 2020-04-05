package com.edu.ctbu.demo.webapi;


import com.edu.ctbu.demo.core.PageUtils;
import com.edu.ctbu.demo.domain.Cast;
import com.edu.ctbu.demo.domain.Members;
import com.edu.ctbu.demo.service.CastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webapi/cast")
public class CastRestControlleer {

    @Autowired
    private CastService castService;

    @GetMapping("/list")
    public List<Cast> getAll(){

        List<Cast> casts = castService.findAll();

        return casts;
    }

    /**
     * 分页读取
     */

    @GetMapping("/getbypagenameoftank")
    public PageUtils getByPagenameoftank(@RequestParam(value = "page", defaultValue = "0") Integer page,
                               @RequestParam(value = "size", defaultValue = "10") Integer size,
                               @RequestParam(value = "nameoftank", defaultValue = "") String nameoftank,
                               @RequestParam(value = "product", defaultValue = "") String product) {

        //按照id排序
        Sort sort = Sort.by(Sort.Direction.DESC, "id");

        Page<Cast> castsPage;

        if (StringUtils.isEmpty(nameoftank)) {

            Pageable pageable = PageRequest.of(page, size, sort);

            castsPage = castService.findAll(pageable);

        } else {

            Cast cast = new Cast();

            cast.setNameoftank(nameoftank);

            Pageable pageable = PageRequest.of(page, size, sort);

            ExampleMatcher matcher = ExampleMatcher.matching()

                    .withMatcher("nameoftank", ExampleMatcher.GenericPropertyMatchers.contains());

            Example<Cast> example = Example.of(cast, matcher);

            castsPage = castService.findAll(example,pageable);
        }

        PageUtils pageUtils = new PageUtils(castsPage.getContent(), castsPage.getTotalElements());

        return pageUtils;
    }

    @GetMapping("/getbypageproduct")
    public PageUtils getByPageproduct(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                         @RequestParam(value = "size", defaultValue = "10") Integer size,
                                         @RequestParam(value = "nameoftank", defaultValue = "") String nameoftank,
                                         @RequestParam(value = "product", defaultValue = "") String product) {

        //按照id排序
        Sort sort = Sort.by(Sort.Direction.DESC, "id");

        Page<Cast> castsPage;

        if (StringUtils.isEmpty(product)) {

            Pageable pageable = PageRequest.of(page, size, sort);

            castsPage = castService.findAll(pageable);

        } else {

            Cast cast = new Cast();

            cast.setProduct(product);

            Pageable pageable = PageRequest.of(page, size, sort);

            ExampleMatcher matcher = ExampleMatcher.matching()

                    .withMatcher("product", ExampleMatcher.GenericPropertyMatchers.contains());

            Example<Cast> example = Example.of(cast, matcher);

            castsPage = castService.findAll(example, pageable);
        }

        PageUtils pageUtils = new PageUtils(castsPage.getContent(), castsPage.getTotalElements());

        return pageUtils;
    }

    @GetMapping("/getbypagecardnumber")
    public PageUtils getByPagecardnumber(@RequestParam(value = "page", defaultValue = "0") Integer page,
                                      @RequestParam(value = "size", defaultValue = "10") Integer size,
                                      @RequestParam(value = "nameoftank", defaultValue = "") String nameoftank,
                                      @RequestParam(value = "cardnumber", defaultValue = "") Long cardnumber) {

        //按照id排序
        Sort sort = Sort.by(Sort.Direction.DESC, "id");

        Page<Cast> castsPage;

        if (StringUtils.isEmpty(cardnumber)) {

            Pageable pageable = PageRequest.of(page, size, sort);

            castsPage = castService.findAll(pageable);

        } else {

            Cast cast = new Cast();

            cast.setCardnumber(cardnumber);

            Pageable pageable = PageRequest.of(page, size, sort);

            ExampleMatcher matcher = ExampleMatcher.matching()

                    .withMatcher("cardnumber", ExampleMatcher.GenericPropertyMatchers.contains());

            Example<Cast> example = Example.of(cast, matcher);

            castsPage = castService.findAll(example, pageable);
        }

        PageUtils pageUtils = new PageUtils(castsPage.getContent(), castsPage.getTotalElements());

        return pageUtils;
    }

    @PostMapping("insert")
    public Cast insert(Cast cast){

        Cast cast1 = castService.insert(cast);

        return cast1;
    }

    @PutMapping("/update")
    public Cast update(Cast cast){

        Cast oldcast = castService.getById(cast.getId());

        if (StringUtils.isEmpty(cast.getNameoftank())){

            cast.setNameoftank(oldcast.getNameoftank());
        }

        cast = castService.update(cast);

        return cast;
    }


}
