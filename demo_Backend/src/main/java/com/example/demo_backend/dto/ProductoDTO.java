package com.example.demo_backend.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoDTO {

  private Long id;
  private String nombre;
  private String descripcion;
  private Double precio;
  private Integer stock;
}
