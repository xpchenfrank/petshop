package com.shopping.petshop.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userArea")
public class UserAreaController {

    @Autowired
    private UserService userService;

}
