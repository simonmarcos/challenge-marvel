package com.test.challenge.challenge.controller;

import com.test.challenge.challenge.model.User;
import com.test.challenge.challenge.service.UserCustomService;
import com.test.challenge.challenge.service.dto.UserDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserCustomService userCustomService;

    public UserController(UserCustomService userCustomService) {
        this.userCustomService = userCustomService;
    }

    @PostMapping("/user/save")
    public ResponseEntity<UserDTO> save(@RequestBody User user) {
        UserDTO userDTO = userCustomService.save(user);
        return ResponseEntity.ok(userDTO);
    }
}
