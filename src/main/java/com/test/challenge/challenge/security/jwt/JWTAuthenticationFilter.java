package com.test.challenge.challenge.security.jwt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.challenge.challenge.security.AuthCredentialsDTO;
import com.test.challenge.challenge.security.UserDetailsImpl;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.ZonedDateTime;
import java.util.Collections;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        AuthCredentialsDTO authCredentials = new AuthCredentialsDTO();

        try {
            authCredentials = new ObjectMapper().readValue(request.getReader(), AuthCredentialsDTO.class);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(authCredentials.getEmail(), authCredentials.getPassword(), Collections.emptyList());

        return getAuthenticationManager().authenticate(usernamePasswordAuthenticationToken);
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException, ServletException {
        UserDetailsImpl userDetails = (UserDetailsImpl) authResult.getPrincipal();
        String token = TokenUtils.createToken(userDetails.getName(), userDetails.getUsername());

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(getResponseBodyInString(token));
        response.getWriter().flush();

        super.successfulAuthentication(request, response, chain, authResult);
    }

    private String getResponseBodyInString(String token) throws JsonProcessingException {
        CustomResponse customResponse = new CustomResponse();
        customResponse.setToken(token);
        customResponse.setStatus(HttpStatus.OK);
        customResponse.setDateTime(ZonedDateTime.now().toString());

        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(customResponse);
    }
}
