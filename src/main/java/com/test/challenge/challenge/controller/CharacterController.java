package com.test.challenge.challenge.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class CharacterController {

    @GetMapping("/character")
    public Character findAll() {
        return null;
    }
}
