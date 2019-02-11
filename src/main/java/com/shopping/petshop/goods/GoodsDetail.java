package com.shopping.petshop.goods;

import java.util.List;

/**
 * 用于向前端返回详情页的model
 */
public class GoodsDetail {

    private GoodsSKU sku;
    private List<GoodsSPU> spus;

    public GoodsDetail(GoodsSKU sku, List<GoodsSPU> spus) {
        this.sku = sku;
        this.spus = spus;
    }

    public GoodsSKU getSku() {
        return sku;
    }

    public List<GoodsSPU> getSpus() {
        return spus;
    }
}
