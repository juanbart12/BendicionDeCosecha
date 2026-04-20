package com.example.demo_backend.service;

import com.example.demo_backend.dto.PedidoDTO;
import com.example.demo_backend.model.Pedido;
import com.example.demo_backend.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

  @Autowired
  private PedidoRepository pedidoRepository;

  @Override
  public List<PedidoDTO> obtenerTodas() {
    return pedidoRepository.findAll().stream()
      .map(this::convertirADTO)
      .collect(Collectors.toList());
  }

  @Override
  public PedidoDTO obtenerPorId(Long id) {
    return pedidoRepository.findById(id)
      .map(this::convertirADTO)
      .orElse(null); // O podrías lanzar una excepción personalizada aquí
  }

  @Override
  public PedidoDTO guardar(PedidoDTO pedidoDTO) {
    Pedido pedido = new Pedido();
    // Mapeo de DTO a Entidad
    pedido.setClienteNombre(pedidoDTO.getClienteNombre());
    pedido.setTotal(pedidoDTO.getTotal());
    pedido.setFecha(pedidoDTO.getFecha()); // Asegúrate de tener este campo en ambos

    Pedido guardado = pedidoRepository.save(pedido);

    // Devolvemos el DTO con el ID generado si es necesario
    return convertirADTO(guardado);
  }

  @Override
  public void eliminar(Long id) {
    pedidoRepository.deleteById(id);
  }

  // Método auxiliar para no repetir código de conversión
  private PedidoDTO convertirADTO(Pedido pedido) {
    PedidoDTO dto = new PedidoDTO();
    dto.setClienteNombre(pedido.getClienteNombre());
    dto.setTotal(pedido.getTotal());
    dto.setFecha(pedido.getFecha());
    // Si tu DTO tiene ID, agrégalo aquí: dto.setId(pedido.getId());
    return dto;
  }
}
