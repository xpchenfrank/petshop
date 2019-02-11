package com.shopping.petshop.utils;

import java.util.HashMap;

public class ShopReturnObject {

    private static final int SUCCESS_CODE = 200;
    private static final int ERROR_CODE = 500;

    private String msg;
    private Object data;
    private int retcode;

    public static ShopReturnObject success() {
        ShopReturnObject o = new ShopReturnObject();
        o.retcode = SUCCESS_CODE;
        return o;
    }

    public static ShopReturnObject success(Object data) {
        ShopReturnObject o = new ShopReturnObject();
        o.data = data;
        o.retcode = SUCCESS_CODE;
        return o;
    }

    public static ShopReturnObject error(int retCode, String msg) {
        ShopReturnObject o = new ShopReturnObject();
        o.msg = msg;
        o.retcode = retCode;
        return o;
    }

    public static ShopReturnObject error(Exception e) {
        ShopReturnObject o = new ShopReturnObject();
        if (e instanceof ShopException) {
            ShopException se = (ShopException) e;
            o.retcode = se.getType().getRetCode();
            o.msg = se.getMessage();
        } else {
            o.retcode = ERROR_CODE;
            o.msg = e.getMessage();
        }
        return o;
    }

    public String getMsg() {
        return msg;
    }

    public int getRetcode() {
        return retcode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public void putData(String key, Object value) {
        if (data == null) {
            data = new HashMap<String, Object>();
        }
        if (data instanceof HashMap) {
            HashMap<String, Object> dataMap = (HashMap<String, Object>) data;
            dataMap.put(key, value);
        } else {
            throw new ShopException("data put error", ShopExceptionType.LOGIC_EXCEPTION);
        }
    }
}
