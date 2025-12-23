package com.Compose.AuthService.security;

import com.Compose.AuthService.model.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Component
public class JwtUtils {
    @Value("${jwt.accessTokenKey}")
    private String accessTokenKey;

    @Value("${jwt.refreshTokenKey}")
    private String refreshTokenKey;

    private SecretKey getAccessTokenKey(){
        return Keys.hmacShaKeyFor(accessTokenKey.getBytes(StandardCharsets.UTF_8));
    }

    private SecretKey getRefreshTokenKey(){
        return Keys.hmacShaKeyFor(accessTokenKey.getBytes(StandardCharsets.UTF_8));
    }

    public String generateAccessToken(User user){
        String subject = user.getId() + ":" + user.getUsername();
        return Jwts.builder()
                .subject(subject)
                .claim("UserId", user.getId())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000 * 60 * 60))
                .signWith(getAccessTokenKey())
                .compact();
    }

    public String generateRefreshToken(User user){
        return Jwts.builder()
                .subject(user.getUsername())
                .claim("UserId", user.getId())
                .issuedAt(new Date())
                .expiration(new Date(System.currentTimeMillis()+1000 * 60 * 60 * 24 * 10))
                .signWith(getRefreshTokenKey())
                .compact();
    }

    public Map<String, Object> getUserDetailsFromAccessToken(String token){
        Claims claims = Jwts.parser()
                .verifyWith(getAccessTokenKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        String subject = claims.getSubject();
        String[] parts = subject.split(":");

        Long userId = Long.parseLong(parts[0]);
        String username = parts[1];

        Map<String, Object> userDetails = new HashMap<>();
        userDetails.put("userId", userId);
        userDetails.put("username", username);

        return userDetails;
    }

    public Map<String, Object> getUserDetailsFromRefreshToken(String token){
        Claims claims = Jwts.parser()
                .verifyWith(getRefreshTokenKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        String subject = claims.getSubject();
        String[] parts = subject.split(":");

        Long userId = Long.parseLong(parts[0]);
        String username = parts[1];

        Map<String, Object> userDetails = new HashMap<>();
        userDetails.put("userId", userId);
        userDetails.put("username", username);

        return userDetails;
    }
}
