package com.shopping.petshop.user;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.shopping.petshop.config.ShopProperties;
import com.shopping.petshop.utils.ShopException;
import com.shopping.petshop.utils.ShopExceptionType;
import org.springframework.stereotype.Service;

@Service
public class SmsService {

    private final ShopProperties shopProperties;
    private static final String SMS_PRODUCT = "Dysmsapi";
    private static final String SMS_DOMAIN = "dysmsapi.aliyuncs.com";

    public SmsService(ShopProperties shopProperties) {
        this.shopProperties = shopProperties;
    }

    public void sendValidationSms(String phone, int code) {
        try {
            IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", shopProperties.getSmsAccessId(),
                    shopProperties.getSmsAccessKey());
            DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", SMS_PRODUCT, SMS_DOMAIN);
            IAcsClient acsClient = new DefaultAcsClient(profile);

            SendSmsRequest request = new SendSmsRequest();
            request.setMethod(MethodType.POST);
            request.setPhoneNumbers(phone);
            System.out.println("sign:" + shopProperties.getSignName());
            request.setSignName(shopProperties.getSignName());
            request.setTemplateCode(shopProperties.getTemplateCode());
            request.setTemplateParam("{\"code\":\"" + code + "\"}");

            SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);
            if (!"OK".equalsIgnoreCase(sendSmsResponse.getCode())) { // 没有正常收到结果
                throw new ShopException("sms send error. code: " + sendSmsResponse.getCode() + ", msg: " + sendSmsResponse.getMessage(), ShopExceptionType.THIRD_EXCEPTION);
            }
        } catch (ClientException e) {
            throw new ShopException(e, ShopExceptionType.THIRD_EXCEPTION);
        }
    }

}
