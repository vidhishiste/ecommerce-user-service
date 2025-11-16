package com.Ecommerce.user.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

  private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour
  //    private final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256); // secret key
  private final SecretKey key;

  public JwtUtil(@Value("${jwt.secret}") String secret) {
    this.key = Keys.hmacShaKeyFor(secret.getBytes());
  }

  public String generateToken(String email) {
    return Jwts.builder()
        .setSubject(email)
        .setIssuedAt(new Date())
        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
        .signWith(key)
        .compact();
  }

  public String extractEmail(String token) {
    return Jwts.parser() // new way in 0.12.x
        .verifyWith(key) // verify signature
        .build()
        .parseSignedClaims(token) // parse + verify in one step
        .getPayload()
        .getSubject();
  }
}
