package com.shopping.petshop.goods;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/goods")
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @RequestMapping("/{id}")
    GoodsDetail getGoodsDetail(@PathVariable(name = "id") String skukId) {

        System.out.println("sdfsdfsdfsdfsdfsdf");

        System.out.println("ASDAFSDF");

        return goodsService.getGoodsDetail(skukId);
    }

}
