package com.test.challenge.security.jwt;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JWTAuthorizationFilter extends OncePerRequestFilter {

    private final TokenUtils tokenUtils;

    private static final String HEADER_TOKEN_PREFIX = "Bearer ";
    private static final String HEADER_AUTHORIZATION = "Authorization";

    public JWTAuthorizationFilter(TokenUtils tokenUtils) {
        this.tokenUtils = tokenUtils;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String bearerToken = request.getHeader(HEADER_AUTHORIZATION);

        if (bearerToken != null && bearerToken.startsWith(HEADER_TOKEN_PREFIX)) {
            String token = bearerToken.replace(HEADER_TOKEN_PREFIX, "");
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = tokenUtils.getAuthentication(token);

            SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
        }

        filterChain.doFilter(request, response);
    }
}
