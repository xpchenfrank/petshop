package com.shopping.petshop.goods;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

/**
 * 商品大类
 */
@Entity
@Table(name = "goods_sku")
public class GoodsSKU {

    @Id
    private String skuId;

    /**
     * 商品名称
     */
    private String name;
    /**
     * 商品种类
     */
    private String goodsType;
    /**
     * 商品描述
     */
    private String desc;
    /**
     * 图片
     */
    private String pics;
    /**
     * 详情html
     */
    private String detailHtml;
    /**
     * 快递信息
     */
    private String expressInfo;
    /**
     *
     */
    private LocalDateTime updateTime;

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

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public String getDetailHtml() {
        return detailHtml;
    }

    public void setDetailHtml(String detailHtml) {
        this.detailHtml = detailHtml;
    }

    public String getExpressInfo() {
        return expressInfo;
    }

    public void setExpressInfo(String expressInfo) {
        this.expressInfo = expressInfo;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }
}
