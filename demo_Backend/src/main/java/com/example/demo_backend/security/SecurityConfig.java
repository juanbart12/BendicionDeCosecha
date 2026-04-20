package com.example.demo_backend.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
      .csrf(csrf -> csrf.disable()) // Deshabilitamos CSRF para APIs REST
      .cors(cors -> cors.configure(http)) // Habilitamos el CrossOrigin que pusiste en los controllers
      .authorizeHttpRequests(auth -> auth
        .requestMatchers("/api/auth/**").permitAll() // Permite login y registro sin token
        .requestMatchers("/h2-console/**").permitAll() // Permite entrar a la base de datos
        .anyRequest().permitAll() // ⚠️ POR AHORA: Permite todo para que puedas probar
      )
      .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
      .headers(headers -> headers.frameOptions(frame -> frame.disable())); // Necesario para ver la consola H2

    return http.build();
  }
}
