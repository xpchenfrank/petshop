package com.shopping.petshop.utils;

public class ShopException extends RuntimeException {

    private ShopExceptionType type;

    public ShopException(String message, ShopExceptionType type) {
        super(message);
        this.type = type;
    }

    public ShopException(String message, Throwable cause, ShopExceptionType type) {
        super(message, cause);
        this.type = type;
    }

    public ShopException(ShopExceptionType type) {
        super(type.getDefaultMsg());
        this.type = type;
    }

    public ShopException(Throwable cause, ShopExceptionType type) {
        super(type.getDefaultMsg(), cause);
        this.type = type;
    }

    public ShopExceptionType getType() {
        return type;
    }
}
