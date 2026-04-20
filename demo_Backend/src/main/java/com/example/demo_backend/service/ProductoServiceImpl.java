package com.example.demo_backend.service;

import com.example.demo_backend.dto.ProductoDTO;
import com.example.demo_backend.model.Producto;
import com.example.demo_backend.repository.ProductoRepository; // Ajustado a tu carpeta "repositoy"
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductoServiceImpl implements ProductoService {

  @Autowired
  private ProductoRepository productoRepository;

  @Override
  public List<ProductoDTO> obtenerTodos() {
    return productoRepository.findAll().stream()
      .map(this::convertirADTO)
      .collect(Collectors.toList());
  }

  @Override
  public ProductoDTO obtenerPorId(Long id) {
    return productoRepository.findById(id)
      .map(this::convertirADTO)
      .orElseThrow(() -> new RuntimeException("Producto no encontrado"));
  }

  @Override
  public ProductoDTO guardar(ProductoDTO dto) {
    Producto producto = dto.getId() != null ?
      productoRepository.findById(dto.getId()).orElse(new Producto()) : new Producto();

    producto.setNombre(dto.getNombre());
    producto.setDescripcion(dto.getDescripcion());
    producto.setPrecio(dto.getPrecio());
    producto.setStock(dto.getStock());

    Producto guardado = productoRepository.save(producto);
    return convertirADTO(guardado);
  }

  @Override
  public void eliminar(Long id) {
    productoRepository.deleteById(id);
  }

  private ProductoDTO convertirADTO(Producto p) {
    return ProductoDTO.builder()
      .id(p.getId())
      .nombre(p.getNombre())
      .descripcion(p.getDescripcion())
      .precio(p.getPrecio())
      .stock(p.getStock())
      .build();
  }
}
