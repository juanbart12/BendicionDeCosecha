package com.example.demo_backend.controller;

import com.example.demo_backend.dto.PedidoDTO;
import com.example.demo_backend.service.PedidoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pedidos")
@RequiredArgsConstructor
@CrossOrigin("*")
public class PedidoController {

  private final PedidoService pedidoService;

  @GetMapping
  public List<PedidoDTO> listar() {
    return pedidoService.obtenerTodas();
  }

  @GetMapping("/{id}")
  public PedidoDTO obtener(@PathVariable Long id) {
    return pedidoService.obtenerPorId(id);
  }

  @PostMapping
  public PedidoDTO crear(@RequestBody PedidoDTO dto) {
    return pedidoService.guardar(dto);
  }

  @PutMapping("/{id}")
  public PedidoDTO actualizar(@PathVariable Long id, @RequestBody PedidoDTO dto) {
    dto.setId(id);
    return pedidoService.guardar(dto);
  }

  @DeleteMapping("/{id}")
  public void eliminar(@PathVariable Long id) {
    pedidoService.eliminar(id);
  }
}
