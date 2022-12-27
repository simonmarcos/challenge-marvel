package com.test.challenge.challenge.controller;

import com.test.challenge.challenge.model.User;
import com.test.challenge.challenge.service.UserCustomService;
import com.test.challenge.challenge.service.dto.UserDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserCustomService userCustomService;

    public UserController(UserCustomService userCustomService) {
        this.userCustomService = userCustomService;
    }

    @PostMapping("/user/save")
    public ResponseEntity<UserDTO> save(@Valid @RequestBody User user) {
        UserDTO userDTO = userCustomService.save(user);
        return ResponseEntity.ok(userDTO);
    }

    @GetMapping("/user/findByEmail")
    public ResponseEntity<UserDTO> findByEmail(@RequestParam(name = "email") String email) {
        Optional<UserDTO> userDTO = userCustomService.findOneByEmail(email);

        if (!userDTO.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        return ResponseEntity.ok(userDTO.get());
    }
}
