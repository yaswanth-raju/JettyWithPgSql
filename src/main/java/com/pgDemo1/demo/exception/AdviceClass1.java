package com.pgDemo1.demo.exception;

import com.pgDemo1.demo.DemoApplication;
import org.slf4j.LoggerFactory;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.logging.Logger;

@ControllerAdvice
public class AdviceClass1 extends ResponseEntityExceptionHandler {
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(AdviceClass1.class);
    @ExceptionHandler(IncorrectResultSizeDataAccessException.class)
    ResponseEntity handleConflict(RuntimeException ex, WebRequest request){
        log.error("inside handle conflict",ex);
        return handleExceptionInternal(ex,"<h1>There is some thing wrong<h1>",new HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR,request);

    }


}
