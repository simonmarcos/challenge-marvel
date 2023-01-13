package com.test.challenge.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class BusinessExceptions extends RuntimeException {
    private String code;
    private String message;
    private HttpStatus httpStatus;
    private ZonedDateTime dateTime;

    public BusinessExceptions(String code, String message, HttpStatus httpStatus) {
        super(message);
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
        this.dateTime = ZonedDateTime.now();
    }

    @Override
    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public ZonedDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(ZonedDateTime dateTime) {
        this.dateTime = dateTime;
    }
}
