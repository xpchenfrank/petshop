package com.shopping.petshop.goods;

import com.shopping.petshop.utils.ShopException;
import com.shopping.petshop.utils.ShopExceptionType;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class GoodsService {

    private GoodsSkuDAO skuDAO;
    private GoodsSpuDAO spuDAO;

    public GoodsService(GoodsSkuDAO skuDAO, GoodsSpuDAO spuDAO) {
        this.skuDAO = skuDAO;
        this.spuDAO = spuDAO;
    }

    /**
     * 获取商品的详情
     * @param skuId
     * @return
     */
    public GoodsDetail getGoodsDetail(String skuId) {
        Optional<GoodsSKU> sku = skuDAO.findById(skuId);
        List<GoodsSPU> spus = spuDAO.findAllBySkuId(skuId);
        try {
            return new GoodsDetail(sku.get(), spus);
        } catch (NoSuchElementException e) {
            throw new ShopException("skuId不存在", ShopExceptionType.PARAM_EXCEPTION);
        }
    }

}
