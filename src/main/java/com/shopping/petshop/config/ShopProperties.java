package com.shopping.petshop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ShopProperties {

    @Value("${ali.sms.accessId}")
    private String smsAccessId;
    @Value("${ali.sms.accessKey}")
    private String smsAccessKey;
    @Value("${ali.sms.signName}")
    private String signName;
    @Value("${ali.sms.templateCode}")
    private String templateCode;
    @Value("${ali.sms.validTime}")
    private long codeValidTime;

    public String getSmsAccessId() {
        return smsAccessId;
    }

    public String getSmsAccessKey() {
        return smsAccessKey;
    }

    public String getSignName() {
        return signName;
    }

    public String getTemplateCode() {
        return templateCode;
    }

    public long getCodeValidTime() {
        return codeValidTime;
    }

    public void setCodeValidTime(long codeValidTime) {
        this.codeValidTime = codeValidTime;
    }
}
