package com.example.demo_backend.controller;


import com.example.demo_backend.dto.LoginRequest;
import com.example.demo_backend.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

  private final AuthService authService;

  @PostMapping("/login")
  public LoginResponse login(@RequestBody LoginRequest request) {
    return authService.login(request);
  }
}
