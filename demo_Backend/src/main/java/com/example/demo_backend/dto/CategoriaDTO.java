package com.example.demo_backend.dto;


import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CategoriaDTO {

  private Long id;
  private String nombre;
  private String descripcion;
}
