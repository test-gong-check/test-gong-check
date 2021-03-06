package com.woowacourse.gongcheck.exception;

import lombok.Getter;
import org.springframework.web.bind.MethodArgumentNotValidException;

@Getter
public class ErrorResponse {

    private String message;

    private ErrorResponse() {
    }

    private ErrorResponse(final String message) {
        this.message = message;
    }

    public static ErrorResponse from(final RuntimeException e) {
        return new ErrorResponse(e.getMessage());
    }

    public static ErrorResponse from(final MethodArgumentNotValidException e) {
        return new ErrorResponse(e.getAllErrors()
                .get(0)
                .getDefaultMessage());
    }

    public static ErrorResponse from(final String message) {
        return new ErrorResponse(message);
    }
}
