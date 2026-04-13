package com.example.demo_backend.controller;


import  com.example.demo_backend.dto.UsuarioDTO;
import  com.example.demo_backend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UsuarioController {

  private final UsuarioService usuarioService;

  @GetMapping
  public List<UsuarioDTO> listar() {
    return usuarioService.listarUsuarios();
  }

  @GetMapping("/{id}")
  public UsuarioDTO obtener(@PathVariable Long id) {
    return usuarioService.obtenerUsuario(id);
  }

  @PostMapping
  public UsuarioDTO crear(@RequestBody UsuarioDTO dto) {
    return usuarioService.guardarUsuario(dto);
  }

  @PutMapping("/{id}")
  public UsuarioDTO actualizar(@PathVariable Long id, @RequestBody UsuarioDTO dto) {
    dto.setId(id);
    return usuarioService.guardarUsuario(dto);
  }

  @DeleteMapping("/{id}")
  public void eliminar(@PathVariable Long id) {
    usuarioService.eliminarUsuario(id);
  }
}
