package com.shopping.petshop.interceptors;

import com.shopping.petshop.utils.ShopException;
import com.shopping.petshop.utils.ShopExceptionType;
import com.shopping.petshop.utils.ShopReturnObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ShopExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(ShopExceptionHandler.class);

    @ExceptionHandler(ShopException.class)
    @ResponseBody
    public ShopReturnObject handleShopException(ShopException e) {
        logger.error("shop error", e);
        return ShopReturnObject.error(e);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ShopReturnObject handleOtherException(Exception e) {
        logger.error("uncaught error", e);
        return ShopReturnObject.error(e);
    }

}
