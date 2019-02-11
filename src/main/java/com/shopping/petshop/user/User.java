package com.shopping.petshop.user;


import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * 用户基本信息
 */
@Entity
public class User {

    /**
     * 用户id
     */
    @Id
    private String userId;
    /**
     * 微信id
     */
    private String weixinId;
    /**
     * 昵称
     */
    private String name;
    /**
     * 头像
     */
    private String headIcon;
    /**
     * 最后登陆日期
     */
    private LocalDateTime loginDate;
    /**
     * 密码
     */
    private String password;
    /**
     * 登陆标识
     */
    private String sessionKey;
    /**
     * 创建时间
     */
    private LocalDateTime createDate;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getWeixinId() {
        return weixinId;
    }

    public void setWeixinId(String weixinId) {
        this.weixinId = weixinId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHeadIcon() {
        return headIcon;
    }

    public void setHeadIcon(String headIcon) {
        this.headIcon = headIcon;
    }

    public LocalDateTime getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(LocalDateTime loginDate) {
        this.loginDate = loginDate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSessionKey() {
        return sessionKey;
    }

    public void setSessionKey(String sessionKey) {
        this.sessionKey = sessionKey;
    }
}
