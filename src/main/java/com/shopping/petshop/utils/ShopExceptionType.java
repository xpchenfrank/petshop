package com.shopping.petshop.utils;

public enum ShopExceptionType {
    RUNTIME_EXCEPTION(500, "操作异常"),
    PARAM_EXCEPTION(203, "参数异常"),
    LOGIN_EXCEPTION(401, "需要登录"),
    THIRD_EXCEPTION(502, "第三方异常"),
    LOGIC_EXCEPTION(503, "逻辑异常")
    ;

    ShopExceptionType(int retCode, String defaultMsg) {
        this.retCode = retCode;
        this.defaultMsg = defaultMsg;
    }

    private int retCode;
    private String defaultMsg;

    public int getRetCode() {
        return retCode;
    }

    public String getDefaultMsg() {
        return defaultMsg;
    }
}
