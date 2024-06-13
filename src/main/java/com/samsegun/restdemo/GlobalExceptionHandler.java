package com.samsegun.restdemo;

import com.samsegun.restdemo.dao.EntityException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    //entity(DAO) exception handler
    @ExceptionHandler
    public ResponseEntity<GlobalErrorResponse> handleEntityException(EntityException exc) {
        GlobalErrorResponse error = new GlobalErrorResponse();
        int statusCode;

        error.setMessage(exc.getMessage());

        switch (exc.getErrorCode()) {
            case "NOT FOUND" -> statusCode = HttpStatus.NOT_FOUND.value();
            case "INVALID ARGUMENTS" -> statusCode = HttpStatus.FORBIDDEN.value();
            default -> statusCode = HttpStatus.BAD_REQUEST.value();
        }
        error.setStatus(statusCode);

        error.setTimeStamp(System.currentTimeMillis());

        return ResponseEntity
                .status(statusCode)
                .body(error);
    }

    //general exception handler
    @ExceptionHandler
    public ResponseEntity<GlobalErrorResponse> handleException(Exception exc) {
        GlobalErrorResponse error = new GlobalErrorResponse();

        error.setMessage(exc.getMessage());
        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setTimeStamp(System.currentTimeMillis());

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(error);
    }
}
