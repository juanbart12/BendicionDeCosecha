package com.example.demo_backend.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "detalle_pedido")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetallePedido {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Integer cantidad;

  private Double precio;

  private Double subtotal;

  @ManyToOne
  @JoinColumn(name = "pedido_id")
  private Pedido pedido;

  @ManyToOne
  @JoinColumn(name = "producto_id")
  private Producto producto;
}
