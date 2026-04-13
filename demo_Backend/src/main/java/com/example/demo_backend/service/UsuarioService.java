package com.example.demo_backend.service;


import com.example.demo_backend.dto.UsuarioDTO;

import java.util.List;

public interface UsuarioService {

  List<UsuarioDTO> listarUsuarios();

  UsuarioDTO obtenerUsuario(Long id);

  UsuarioDTO guardarUsuario(UsuarioDTO usuarioDTO);

  void eliminarUsuario(Long id);
}
