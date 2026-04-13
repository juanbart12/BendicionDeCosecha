package com.example.demo_backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ContactoDTO {

  private Long id;
  private String nombre;
  private String email;
  private String mensaje;
}
