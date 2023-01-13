package com.test.challenge.controller;

import com.test.challenge.security.jwt.TokenUtils;
import com.test.challenge.service.dto.AuthCredentialsDTO;
import com.test.challenge.service.dto.CustomResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
public class LoginController {

    private final AuthenticationManager authenticationManager;
    private final TokenUtils tokenUtils;

    public LoginController(AuthenticationManager authenticationManager, TokenUtils tokenUtils) {
        this.authenticationManager = authenticationManager;
        this.tokenUtils = tokenUtils;
    }

    @PostMapping("/login")
    public ResponseEntity<CustomResponseDTO> login(@Valid @RequestBody AuthCredentialsDTO authCredentialsDTO) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authCredentialsDTO.getEmail(), authCredentialsDTO.getPassword()));

        String token = tokenUtils.createToken(authentication.getName(), authCredentialsDTO.getEmail());

        CustomResponseDTO customResponseDTO = new CustomResponseDTO();
        customResponseDTO.setToken(token);
        customResponseDTO.setStatus(HttpStatus.OK);
        customResponseDTO.setDateTime(LocalDateTime.now().toString());

        return ResponseEntity.ok(customResponseDTO);
    }
}
