package com.backend.business.exeptions;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundUserExeptions extends RuntimeException {
    private String message;
    private int code;
    private HttpStatus http;

}
