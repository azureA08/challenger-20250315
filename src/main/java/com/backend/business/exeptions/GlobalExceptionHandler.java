package com.backend.business.exeptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(UserNombreAlreadyExistsException.class)
    public ResponseEntity<ResponseException> usernameAlreadyExistsException(UserNombreAlreadyExistsException exception) {
        ResponseException apiResponseException = new ResponseException(exception.getMessage(), exception.getCode(), exception.getHttp());
        return ResponseEntity.status(exception.getHttp()).body(apiResponseException);
    }

    @ExceptionHandler(NotFoundUserExeptions.class)
    public ResponseEntity<ResponseException> notFoundProductExeptionsException(NotFoundUserExeptions userExeptions) {
        ResponseException apiResponseException = new ResponseException(userExeptions.getMessage(), userExeptions.getCode(), userExeptions.getHttp());
        return ResponseEntity.status(userExeptions.getHttp()).body(apiResponseException);
    }

    public ResponseEntity<ResponseException> invalidProductEx(UserInvalidoException exeptions) {
        ResponseException apiResponseException = new ResponseException(exeptions.getMessage(), exeptions.getCode(), exeptions.getHttp());
        return ResponseEntity.status(exeptions.getHttp()).body(apiResponseException);
    }
}
