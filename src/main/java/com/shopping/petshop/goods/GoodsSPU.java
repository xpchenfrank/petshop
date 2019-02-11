package com.shopping.petshop.goods;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 商品小类
 */
@Entity
@Table(name = "goods_spu")
public class GoodsSPU {

    /**
     *
     */
    @Id
    private String spuId;

    /**
     * 所属sku
     */
    private String skuId;
    /**
     * spu名称
     */
    private String name;
    /**
     * 商品图片
     */
    private String pics;
    /**
     *
     */
    private LocalDateTime updateTime;

    public String getSpuId() {
        return spuId;
    }

    public void setSpuId(String spuId) {
        this.spuId = spuId;
    }

    public String getSkuId() {
        return skuId;
    }

    public void setSkuId(String skuId) {
        this.skuId = skuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
