package com.shopping.petshop.user;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * 用户常用地址信息
 */
@Entity
public class UserArea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long areaId;

    /**
     * 用户id
     */
    private String userId;
    /**
     * 省
     */
    private String province;
    /**
     * 市
     */
    private String city;
    /**
     * 区
     */
    private String district;
    /**
     * 电话号码
     */
    private String phone;
    /**
     * 地址名，非用户名
     */
    private String name;
    /**
     * 卡号
     */
    private String cardNo;
    /**
     * 备注
     */
    private String memo;
    /**
     * 是否为首选地址（每人只有一个）
     */
    private boolean isDefault;
    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
    /**
     * 建立时间
     */
    private LocalDateTime createTime;

    public long getAreaId() {
        return areaId;
    }

    public void setAreaId(long areaId) {
        this.areaId = areaId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }
}
