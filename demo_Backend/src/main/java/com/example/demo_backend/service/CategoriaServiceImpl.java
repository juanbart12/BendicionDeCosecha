package com.example.demo_backend.service;

import com.example.demo_backend.dto.CategoriaDTO;
import com.example.demo_backend.model.Categoria;
import com.example.demo_backend.repository.CategoriaRepository; // Verifica si es "repository" o "repositoy"
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoriaServiceImpl implements CategoriaService {

  @Autowired
  private CategoriaRepository categoriaRepository;

  @Override
  public List<CategoriaDTO> obtenerTodas() {
    return categoriaRepository.findAll().stream()
      .map(cat -> CategoriaDTO.builder()
        .id(cat.getId())
        .nombre(cat.getNombre())
        .descripcion(cat.getDescripcion())
        .build())
      .collect(Collectors.toList());
  }

  @Override
  public CategoriaDTO obtenerPorId(Long id) {
    return categoriaRepository.findById(id)
      .map(cat -> CategoriaDTO.builder()
        .id(cat.getId())
        .nombre(cat.getNombre())
        .descripcion(cat.getDescripcion())
        .build())
      .orElse(null);
  }

  @Override
  public CategoriaDTO guardar(CategoriaDTO dto) {
    Categoria categoria = new Categoria();
    // Si el DTO trae ID, es una actualización
    if (dto.getId() != null) {
      categoria.setId(dto.getId());
    }
    categoria.setNombre(dto.getNombre());
    categoria.setDescripcion(dto.getDescripcion());

    Categoria guardada = categoriaRepository.save(categoria);

    return CategoriaDTO.builder()
      .id(guardada.getId())
      .nombre(guardada.getNombre())
      .descripcion(guardada.getDescripcion())
      .build();
  }

  @Override
  public void eliminar(Long id) {
    categoriaRepository.deleteById(id);
  }
}
