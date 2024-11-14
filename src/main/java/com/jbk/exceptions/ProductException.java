package com.jbk.exceptions;

public class ProductException extends RuntimeException {
    public ProductException(String message, Exception e) {
        super(message);
    }
}
