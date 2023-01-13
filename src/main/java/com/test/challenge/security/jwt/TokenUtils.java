package com.test.challenge.security.jwt;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class TokenUtils {

    @Value("${api.access.token.secret}")
    private String ACCESS_TOKEN_SECRET;
    @Value("${api.access.token.validity.second}")
    private Long ACCESS_TOKEN_VALIDITY_SECOND;

    public String createToken(String name, String email) {
        Date expirationDate = new Date(System.currentTimeMillis() + this.ACCESS_TOKEN_VALIDITY_SECOND * 24);

        Map<String, Object> payload = new HashMap<>();
        payload.put("name", name);

        return Jwts.builder()
                .setSubject(email)
                .setExpiration(expirationDate)
                .addClaims(payload)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

    public UsernamePasswordAuthenticationToken getAuthentication(String token) throws JwtException {
        Claims claims = Jwts.parserBuilder()
                .setSigningKey(Keys.hmacShaKeyFor(this.ACCESS_TOKEN_SECRET.getBytes()))
                .build()
                .parseClaimsJws(token)
                .getBody();

        String email = claims.getSubject();

        return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());

    }
}
