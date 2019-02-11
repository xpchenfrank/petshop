package com.shopping.petshop.user;

import com.shopping.petshop.config.ShopProperties;
import com.shopping.petshop.utils.ShopException;
import com.shopping.petshop.utils.ShopExceptionType;
import com.shopping.petshop.utils.ShopReturnObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class UserService {

    private final UserDAO userDAO;
    private final UserAreaDAO userAreaDAO;
    private final UserPhoneCodeDAO userPhoneCodeDAO;

    @Autowired
    private SmsService smsService;
    @Autowired
    private ShopProperties shopProperties;

    private final Random random = new Random();

    public UserService(UserDAO userDAO, UserAreaDAO userAreaDAO, UserPhoneCodeDAO userPhoneCodeDAO) {
        this.userDAO = userDAO;
        this.userAreaDAO = userAreaDAO;
        this.userPhoneCodeDAO = userPhoneCodeDAO;
    }

    public User getUserById(String userId) {
        return userDAO.findById(userId).orElse(null);
    }

    public User getUserByName(String name) {
        return userDAO.findUserByName(name);
    }

    public List<UserArea> getAllUserAreasByUserId(String userId) {
        return userAreaDAO.findAllByUserId(userId);
    }

    /**
     * 设置用户的默认常用地址
     * @param userId
     * @param areaId
     */
    @Transactional
    public void setDefaultUserArea(String userId, long areaId) {
        Optional<UserArea> userArea = userAreaDAO.findById(areaId);
        if (!userArea.isPresent() || !userArea.get().getUserId().equals(userId)) {
            throw new ShopException("areaId: " + areaId + "不存在或不属于userId: " + userId, ShopExceptionType.PARAM_EXCEPTION);
        }
        userAreaDAO.updateToNoDefault(userId); // 清除用户默认
        UserArea ua = userArea.get();
        ua.setDefault(true);
        userAreaDAO.save(ua); // 写入新默认
    }

    public UserPhoneCode generateCode(String phone) {
        Optional<UserPhoneCode> upc = userPhoneCodeDAO.findByPhone(phone);
        UserPhoneCode userPhoneCode = upc.orElse(null);
        if (userPhoneCode == null) {
            userPhoneCode = new UserPhoneCode();
            userPhoneCode.setPhone(phone);
        }
        userPhoneCode.setPhoneCode(1000 + random.nextInt(9000)); // 生成验证码
        userPhoneCodeDAO.saveAndFlush(userPhoneCode);
        System.out.println("userPhoneCode = " + userPhoneCode);
        return userPhoneCode;
    }

    /**
     * 发送验证码
     * @param phone
     */
    @Transactional
    public void sendCode(String phone) {
        UserPhoneCode userPhoneCode = generateCode(phone);
        smsService.sendValidationSms(phone, userPhoneCode.getPhoneCode());
    }

    /**
     * 校验验证码
     * @param phone
     * @param code
     */
    public void isCodeValid(String phone, int code) {
        Optional<UserPhoneCode> upc = userPhoneCodeDAO.findByPhone(phone);
        if (!upc.isPresent()) { // 没发过
            throw new ShopException("没有发送过验证码", ShopExceptionType.LOGIC_EXCEPTION);
        }
        UserPhoneCode userPhoneCode = upc.get();
        long now = System.currentTimeMillis();
        if (now - userPhoneCode.getUpdateTime().getTime() > shopProperties.getCodeValidTime()) {
            throw new ShopException("验证码超时", ShopExceptionType.LOGIC_EXCEPTION);
        }
        if (userPhoneCode.getPhoneCode() != code) {
            throw new ShopException("验证失败", ShopExceptionType.LOGIC_EXCEPTION);
        }
    }

}
