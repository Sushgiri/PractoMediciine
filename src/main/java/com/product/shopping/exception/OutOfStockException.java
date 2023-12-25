package com.product.shopping.exception;

public class OutOfStockException extends RuntimeException {

    private String message;

    public OutOfStockException(String message)  {
super(message);
    }
}
