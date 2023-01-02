package com.study.springboot202010kkr.web.Exception;

import lombok.Getter;

import java.util.Map;

public class CustomTestException extends RuntimeException {
    @Getter
    private Map<String, String> errorMap;

    public CustomTestException(String message, Map<String, String> errorMap) {
        super(message);
        this.errorMap = errorMap;
    }
}
