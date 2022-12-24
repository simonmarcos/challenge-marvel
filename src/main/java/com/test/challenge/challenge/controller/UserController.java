package com.test.challenge.challenge.controller;

import com.test.challenge.challenge.model.User;
import com.test.challenge.challenge.service.UserService;
import com.test.challenge.challenge.service.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public ResponseEntity<UserDTO> save(@RequestBody User user) {
        UserDTO userDTO = userService.save(user);
        return ResponseEntity.ok(userDTO);
    }
}
