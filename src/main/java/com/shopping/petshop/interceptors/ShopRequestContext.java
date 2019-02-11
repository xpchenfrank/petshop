package com.shopping.petshop.interceptors;

import com.shopping.petshop.config.ShopConstant;
import com.shopping.petshop.user.User;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.HashMap;
import java.util.Map;

/**
 * 上下文存储常用内容
 */
@Component
@RequestScope
public class ShopRequestContext {

    private final Map<String, Object> contextMap = new HashMap<>();

    private User user;

    /**
     * 暂时写死，造成单店铺
     *
     * @return
     */
    public long getShopId() {
        return ShopConstant.SHOP_ID_CONSTANT;
    }

    public Map<String, Object> getContextMap() {
        return contextMap;
    }

    public <T> T get(String key) {
        return (T) getContextMap().get(key);
    }

    public void set(String key, Object value) {
        getContextMap().put(key, value);
    }

    public User getUser() {
        return user;
    }

}
