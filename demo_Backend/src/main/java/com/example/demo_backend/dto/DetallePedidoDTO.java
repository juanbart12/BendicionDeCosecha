package com.example.demo_backend.dto;



import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DetallePedidoDTO {

  private Long productoId;
  private Integer cantidad;
  private Double precio;
}
