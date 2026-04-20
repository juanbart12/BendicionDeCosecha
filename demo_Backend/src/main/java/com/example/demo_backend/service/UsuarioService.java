package com.example.demo_backend.service;

import com.example.demo_backend.dto.UsuarioDTO;
import java.util.List;

public interface UsuarioService {

  UsuarioDTO registrarUsuario(UsuarioDTO usuarioDTO);

  List<UsuarioDTO> listarUsuarios();

  UsuarioDTO obtenerUsuario(Long id); // Este es el que te está pidiendo IntelliJ

  void eliminarUsuario(Long id);
}
