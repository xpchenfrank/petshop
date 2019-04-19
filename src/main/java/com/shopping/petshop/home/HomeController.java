package com.shopping.petshop.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    
    private int a; // test

    @Autowired
    private HomeService homeService;

    @GetMapping("/getNowBanner")
    List<HomeBanner> getNowBanner() {
        return homeService.getNowBanner();
    }

    @GetMapping("/getNowRecommend")
    List<HomeRecommend> getNowRecommend() { // jjjjjjajaj
        return homeService.getNowRecommend();
    }

}
