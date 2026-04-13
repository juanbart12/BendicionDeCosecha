package com.example.demo_backend.service;


import com.example.demo_backend.dto.ProductoDTO;
import java.util.List;

public interface ProductoService {

  List<ProductoDTO> obtenerTodos();

  ProductoDTO obtenerPorId(Long id);

  ProductoDTO guardar(ProductoDTO productoDTO);

  void eliminar(Long id);
}
