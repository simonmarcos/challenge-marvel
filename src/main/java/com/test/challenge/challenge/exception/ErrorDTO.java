package com.test.challenge.challenge.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;

public class ErrorDTO {
    private String code;
    private String message;
    private HttpStatus httpStatus;
    private ZonedDateTime dateTime;

    public ErrorDTO(String code, String message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.httpStatus = httpStatus;
    }

    public ErrorDTO() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
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

    @Override
    public String toString() {
        return "ErrorDTO{" +
                "code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", httpStatus=" + httpStatus +
                ", zonedDateTime=" + dateTime +
                '}';
    }
}
