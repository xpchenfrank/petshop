package com.shopping.petshop.user;

import org.apache.catalina.util.ToStringUtil;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
public class UserPhoneCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    /**
     * 手机号码
     */
    private String phone;
    /**
     * 手机验证码
     */
    private int phoneCode;
    /**
     * 更新时间
     */
    private Date updateTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(int phoneCode) {
        this.phoneCode = phoneCode;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}
