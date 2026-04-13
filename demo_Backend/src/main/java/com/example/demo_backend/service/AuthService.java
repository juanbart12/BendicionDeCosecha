package com.example.demo_backend.service;


import com.example.demo_backend.dto.LoginRequest;
import com.example.demo_backend.dto.LoginResponse;

public interface AuthService {
  LoginResponse login(LoginRequest request);
}
