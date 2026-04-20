package com.example.demo_backend.service;

import com.example.demo_backend.dto.LoginRequest;
import com.example.demo_backend.dto.LoginResponse;
import org.springframework.stereotype.Service;

@Service // <-- AQUÍ es donde Spring lo reconoce y crea el Bean
public class AuthServiceImpl implements AuthService {

  @Override
  public LoginResponse login(LoginRequest request) {
    // Aquí va tu lógica de validación de usuario para "Bendición de Cosecha"
    return new LoginResponse("Token de ejemplo");
  }
}
