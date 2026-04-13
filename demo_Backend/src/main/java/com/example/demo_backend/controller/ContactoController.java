package com.example.demo_backend.controller;


import com.example.demo_backend.dto.ContactoDTO;
import com.example.demo_backend.service.ContactoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/contactos")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ContactoController {

  private final ContactoService contactoService;

  @PostMapping
  public ContactoDTO guardar(@RequestBody ContactoDTO dto) {
    return contactoService.guardarMensaje(dto);
  }

  @GetMapping
  public List<ContactoDTO> listar() {
    return contactoService.listarMensajes();
  }
}
