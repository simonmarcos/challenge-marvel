package com.test.challenge.challenge.controller;

import com.test.challenge.challenge.exception.RequestException;
import com.test.challenge.challenge.service.dto.AuthCredentialsDTO;
import com.test.challenge.challenge.service.dto.CustomResponseDTO;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDateTime;

@RestController
public class LoginController {

    private final static String ACCESS_TOKEN_SECRET = "29ee1086e919e5f142bf1312f80a2c67253de4d6f41cdfab715c34acbcb1d8e7";
    private final AuthenticationManager authenticationManager;

    public LoginController(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/login")
    public ResponseEntity<CustomResponseDTO> login(@Valid @RequestBody AuthCredentialsDTO authCredentialsDTO) {

        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authCredentialsDTO.getEmail(), authCredentialsDTO.getPassword()));

        String token = Jwts.builder().setSubject(authentication.getName()).signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes())).compact();

        CustomResponseDTO customResponseDTO = new CustomResponseDTO();
        customResponseDTO.setToken(token);
        customResponseDTO.setStatus(HttpStatus.OK);
        customResponseDTO.setDateTime(LocalDateTime.now().toString());

        return ResponseEntity.ok(customResponseDTO);
    }
}
