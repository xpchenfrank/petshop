package com.shopping.petshop.user;

import com.shopping.petshop.utils.ShopReturnObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public ShopReturnObject sendCode() {
        userService.sendCode("17600852034");
        return ShopReturnObject.success();
    }
}