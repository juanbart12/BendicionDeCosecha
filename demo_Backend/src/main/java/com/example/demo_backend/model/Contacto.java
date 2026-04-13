package com.example.demo_backend.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "contactos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Contacto {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String nombre;

  private String email;

  private String mensaje;
}
