package com.shopping.petshop.user;

import com.shopping.petshop.utils.ShopReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    User getUserById(@PathVariable("id") String userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("/getUserByName")
    User getUserByName(@RequestParam(required = false, defaultValue = "") String name) {
        return userService.getUserByName(name);
    }

    @GetMapping("/sendCode")
    ShopReturnObject sendCode(@RequestParam String phone) {
        userService.sendCode(phone);
        return ShopReturnObject.success();
    }

    @GetMapping("/validCode")
    ShopReturnObject validCode(@RequestParam String phone, @RequestParam int code) {
        userService.isCodeValid(phone, code);
        return ShopReturnObject.success();
    }

}
