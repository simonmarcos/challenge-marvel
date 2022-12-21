package com.test.challenge.challenge.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class BusinessExceptions extends RuntimeException {
    private String code;
    private String message;
    private HttpStatus httpStatus;
    private ZonedDateTime zonedDateTime;

    public BusinessExceptions(String code, String message, HttpStatus httpStatus) {
        super(message);
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
        this.zonedDateTime = ZonedDateTime.now();
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

    public ZonedDateTime getZonedDateTime() {
        return zonedDateTime;
    }

    public void setZonedDateTime(ZonedDateTime zonedDateTime) {
        this.zonedDateTime = zonedDateTime;
    }
}
