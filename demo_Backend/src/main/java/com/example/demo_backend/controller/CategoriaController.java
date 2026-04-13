package com.example.demo_backend.controller;


import com.example.demo_backend.dto.CategoriaDTO;
import com.example.demo_backend.service.CategoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categorias")
@RequiredArgsConstructor
@CrossOrigin("*")
public class CategoriaController {

  private final CategoriaService categoriaService;

  @GetMapping
  public List<CategoriaDTO> listar() {
    return categoriaService.obtenerTodas();
  }

  @GetMapping("/{id}")
  public CategoriaDTO obtener(@PathVariable Long id) {
    return categoriaService.obtenerPorId(id);
  }

  @PostMapping
  public CategoriaDTO crear(@RequestBody CategoriaDTO dto) {
    return categoriaService.guardar(dto);
  }

  @PutMapping("/{id}")
  public CategoriaDTO actualizar(@PathVariable Long id, @RequestBody CategoriaDTO dto) {
    dto.setId(id);
    return categoriaService.guardar(dto);
  }

  @DeleteMapping("/{id}")
  public void eliminar(@PathVariable Long id) {
    categoriaService.eliminar(id);
  }
}
