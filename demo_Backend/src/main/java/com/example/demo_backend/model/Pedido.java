package com.example.demo_backend.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "pedidos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private LocalDate fecha;

  private Double total;

  private String clienteNombre;

  @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
  private List<DetallePedido> detalles;
}

