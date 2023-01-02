package com.study.springboot202010kkr.web.controller.advice;

import com.study.springboot202010kkr.web.Exception.CustomTestException;
import com.study.springboot202010kkr.web.dto.CMRespDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class ApiControllerAdvice {
    @ExceptionHandler(CustomTestException.class)
    public ResponseEntity<?> testException(CustomTestException e) {
        return ResponseEntity.badRequest().body(new CMRespDto<>(e.getMessage(), e.getErrorMap()));
    }
}
