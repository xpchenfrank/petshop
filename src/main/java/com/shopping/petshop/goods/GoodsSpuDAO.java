package com.shopping.petshop.goods;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GoodsSpuDAO extends JpaRepository<GoodsSPU, String> {

    public List<GoodsSPU> findAllBySkuId(String skuId);

}
