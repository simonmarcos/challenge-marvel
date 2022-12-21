package com.test.challenge.challenge.service.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserDTO implements Serializable {

    private String id;

    private String firstName;

    private String lastName;
}
