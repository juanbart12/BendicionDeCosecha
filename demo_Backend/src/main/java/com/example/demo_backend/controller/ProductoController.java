package com.example.demo_backend.controller;

import com.example.demo_backend.dto.ProductoDTO;
import com.example.demo_backend.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProductoController {

  private final ProductoService productoService;

  @GetMapping
  public List<ProductoDTO> listar() {
    return productoService.obtenerTodos();
  }

  @GetMapping("/{id}")
  public ProductoDTO obtener(@PathVariable Long id) {
    return productoService.obtenerPorId(id);
  }

  @PostMapping
  public ProductoDTO crear(@RequestBody ProductoDTO dto) {
    return productoService.guardar(dto);
  }

  @PutMapping("/{id}")
  public ProductoDTO actualizar(@PathVariable Long id, @RequestBody ProductoDTO dto) {
    dto.setId(id);
    return productoService.guardar(dto);
  }

  @DeleteMapping("/{id}")
  public void eliminar(@PathVariable Long id) {
    productoService.eliminar(id);
  }
}
