// InvalidInputException.java
package com.soft.application.exception;

public class InvalidInputException extends BaseException {

    public InvalidInputException(String message) {
        super(message, 400, "INGRESO INVALIDO !!");
    }
}