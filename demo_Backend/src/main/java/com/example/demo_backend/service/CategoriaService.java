package com.example.demo_backend.service;

import com.example.demo_backend.dto.CategoriaDTO;
import java.util.List;

public interface CategoriaService {
  // Eliminamos findAll() porque obtenerTodas() ya cumple esa función con DTOs
  List<CategoriaDTO> obtenerTodas();

  CategoriaDTO obtenerPorId(Long id);

  CategoriaDTO guardar(CategoriaDTO categoriaDTO);

  void eliminar(Long id);
}
