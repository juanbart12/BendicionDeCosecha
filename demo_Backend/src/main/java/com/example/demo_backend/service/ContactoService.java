package com.example.demo_backend.service;


import com.example.demo_backend.dto.ContactoDTO;

import java.util.List;

public interface ContactoService {

  ContactoDTO guardarMensaje(ContactoDTO contactoDTO);

  List<ContactoDTO> listarMensajes();
}
