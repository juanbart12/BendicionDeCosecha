package com.example.demo_backend.service;

import com.example.demo_backend.dto.UsuarioDTO;
import com.example.demo_backend.model.Usuario;
import com.example.demo_backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServiceImpl implements UsuarioService {

  @Autowired
  private UsuarioRepository usuarioRepository;

  @Override
  public UsuarioDTO registrarUsuario(UsuarioDTO dto) {
    Usuario usuario = new Usuario();
    usuario.setNombre(dto.getNombre());
    usuario.setEmail(dto.getEmail());
    usuario.setTelefono(dto.getTelefono());
    usuario.setRol(dto.getRol() != null ? dto.getRol() : "USER");
    usuario.setPassword("12345"); // Idealmente usa BCryptPasswordEncoder

    Usuario guardado = usuarioRepository.save(usuario);
    return convertirADTO(guardado);
  }

  @Override
  public List<UsuarioDTO> listarUsuarios() {
    return usuarioRepository.findAll().stream()
      .map(this::convertirADTO)
      .collect(Collectors.toList());
  }

  @Override
  public UsuarioDTO obtenerUsuario(Long id) { // Implementación del método que faltaba
    return usuarioRepository.findById(id)
      .map(this::convertirADTO)
      .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
  }

  @Override
  public void eliminarUsuario(Long id) {
    usuarioRepository.deleteById(id);
  }

  private UsuarioDTO convertirADTO(Usuario u) {
    return UsuarioDTO.builder()
      .id(u.getId())
      .nombre(u.getNombre())
      .email(u.getEmail())
      .telefono(u.getTelefono())
      .rol(u.getRol())
      .build();
  }
}
