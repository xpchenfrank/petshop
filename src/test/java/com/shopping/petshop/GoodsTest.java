package com.shopping.petshop;

import com.shopping.petshop.goods.GoodsSKU;
import com.shopping.petshop.goods.GoodsSkuDAO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GoodsTest {
    
    @Autowired
    private GoodsSkuDAO skuRepository;
    
    @Test
    public void testSkuRepository() {
        GoodsSKU g = skuRepository.findById("1").orElse(null);
        System.out.println("g = " + g);
    }
}
