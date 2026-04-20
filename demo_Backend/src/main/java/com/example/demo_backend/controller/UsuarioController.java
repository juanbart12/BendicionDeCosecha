package com.example.demo_backend.controller;

import com.example.demo_backend.dto.UsuarioDTO;
import com.example.demo_backend.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public ResponseEntity<UsuarioDTO> obtener(@PathVariable Long id) {
    return ResponseEntity.ok(usuarioService.obtenerUsuario(id));
  }

  @PostMapping
  public ResponseEntity<UsuarioDTO> crear(@RequestBody UsuarioDTO dto) {
    return new ResponseEntity<>(usuarioService.registrarUsuario(dto), HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<UsuarioDTO> actualizar(@PathVariable Long id, @RequestBody UsuarioDTO dto) {
    dto.setId(id);
    return ResponseEntity.ok(usuarioService.registrarUsuario(dto));
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> eliminar(@PathVariable Long id) {
    usuarioService.eliminarUsuario(id);
    return ResponseEntity.noContent().build();
  }
}
