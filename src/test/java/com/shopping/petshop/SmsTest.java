package com.shopping.petshop;

import com.shopping.petshop.user.SmsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SmsTest {

    @Autowired
    private SmsService smsService;

    @Test
    public void testSend() {
        smsService.sendValidationSms("17600852034", 1234);
    }
}
