package com.smartjob.identidad.infrastructure.adapter.out.token;

import java.util.Date;

import org.springframework.stereotype.Component;

import com.smartjob.identidad.domain.port.out.TokenPort;
import com.smartjob.identidad.infrastructure.configuration.JwtConfig;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class TokenJwtAdapter implements TokenPort {
    
    private final JwtConfig jwtConfig;

    @Override
    public String generateToken(String email) {
        Claims claims = Jwts.claims().setSubject(email);
        Date date = new Date();
        Date expiration = new Date(date.getTime() + jwtConfig.getExpiration());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(date)
                .setExpiration(expiration)
                .signWith(SignatureAlgorithm.HS256, jwtConfig.getSecret())
                .compact();
    }
    
}
