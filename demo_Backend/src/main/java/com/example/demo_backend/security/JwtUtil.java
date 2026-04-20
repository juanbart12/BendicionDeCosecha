package com.example.demo_backend.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Component
public class JwtUtil {

  // La llave debe tener al menos 32 caracteres para ser segura con HS256
  private final String SECRET_STRING = "esta_es_una_llave_secreta_muy_larga_y_segura_123456";
  private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET_STRING.getBytes(StandardCharsets.UTF_8));
  private final long EXPIRATION_TIME = 86400000; // 24 horas

  // Método que llamamos en AuthServiceImpl
  public String generateToken(String email) {
    return Jwts.builder()
      .setSubject(email)
      .setIssuedAt(new Date())
      .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
      .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
      .compact();
  }

  public String obtenerEmail(String token) {
    return Jwts.parserBuilder()
      .setSigningKey(SECRET_KEY)
      .build()
      .parseClaimsJws(token)
      .getBody()
      .getSubject();
  }

  public boolean validarToken(String token) {
    try {
      Jwts.parserBuilder().setSigningKey(SECRET_KEY).build().parseClaimsJws(token);
      return true;
    } catch (JwtException | IllegalArgumentException e) {
      return false;
    }
  }
}
