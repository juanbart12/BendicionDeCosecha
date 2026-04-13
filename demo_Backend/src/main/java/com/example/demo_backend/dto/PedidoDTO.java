package com.example.demo_backend.dto;



import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PedidoDTO {

  private Long id;
  private String clienteNombre;
  private List<DetallePedidoDTO> detalles;
}
