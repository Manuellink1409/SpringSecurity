package com.clinident.security.service;

import com.clinident.security.persistence.entities.User;
import io.jsonwebtoken.Header;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {

    @Value("${security.jwt.expiration-in-minutes}")
    private Long EXPIRATION_IN_MILLISECONDS;

    @Value("${security.jwt.secret-key}")
    private String SECRET_KEY;

    public String generateToken(User user , Map<String, Object> extraClaims) {

        Date issuedAt = new Date(System.currentTimeMillis());
        Date expiration = new Date(issuedAt.getTime() + EXPIRATION_IN_MILLISECONDS);

        return Jwts.builder()
                .setClaims(extraClaims)
                .setSubject(user.getEmail())
                .setIssuedAt(issuedAt)
                .setExpiration(expiration)
                .setHeaderParam(Header.JWT_TYPE,Header.JWT_TYPE)
                .signWith(generateToken(), SignatureAlgorithm.HS256)
                .compact();
    }

    private Key generateToken() {

        byte[] key = SECRET_KEY.getBytes();
        return Keys.hmacShaKeyFor(key);

    }

}
