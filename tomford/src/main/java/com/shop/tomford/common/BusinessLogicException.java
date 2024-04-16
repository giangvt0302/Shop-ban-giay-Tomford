package com.shop.tomford.common;

import lombok.Getter;

@Getter
public class BusinessLogicException extends RuntimeException {
    public BusinessLogicException(String message) {
        super(message);
    }

}
