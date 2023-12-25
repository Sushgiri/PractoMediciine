package com.product.shopping.exception;

public class Invalidentries extends RuntimeException {

    private String message;

    public Invalidentries(String message){
        super(message);
    }
}
