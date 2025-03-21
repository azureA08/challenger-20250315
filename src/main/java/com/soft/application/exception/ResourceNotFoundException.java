// ResourceNotFoundException.java
package com.soft.application.exception;

public class ResourceNotFoundException extends BaseException {

    public ResourceNotFoundException(String message) {
        super(message, 404, "No encuentro recurso !!");
    }
}

