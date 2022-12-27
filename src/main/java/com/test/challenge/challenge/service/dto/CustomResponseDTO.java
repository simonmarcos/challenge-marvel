package com.test.challenge.challenge.service.dto;

import org.springframework.http.HttpStatus;

public class CustomResponseDTO {

    private String token;
    private HttpStatus status;
    private String dateTime;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }
}
