package com.test.challenge.challenge.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {RequestException.class})
    public ResponseEntity<ErrorDTO> requestException(RequestException requestException) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode(requestException.getCode());
        errorDTO.setMessage(requestException.getMessage());
        errorDTO.setHttpStatus(requestException.getHttpStatus());

        return new ResponseEntity<>(errorDTO, requestException.getHttpStatus());
    }

    @ExceptionHandler(value = {BusinessExceptions.class})
    public ResponseEntity<ErrorDTO> responseException(BusinessExceptions requestException) {
        ErrorDTO errorDTO = new ErrorDTO();
        errorDTO.setCode(requestException.getCode());
        errorDTO.setMessage(requestException.getMessage());
        errorDTO.setHttpStatus(requestException.getHttpStatus());

        return new ResponseEntity<>(errorDTO, requestException.getHttpStatus());
    }
}
