package com.example.demo_backend.service;

import com.example.demo_backend.dto.ContactoDTO;
import com.example.demo_backend.model.Contacto;
import com.example.demo_backend.repository.ContactoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ContactoServiceImpl implements ContactoService {

  @Autowired
  private ContactoRepository contactoRepository;

  @Override
  public ContactoDTO guardarMensaje(ContactoDTO contactoDTO) {
    // 1. Convertir DTO a Entidad
    Contacto contacto = new Contacto();
    contacto.setNombre(contactoDTO.getNombre());
    contacto.setEmail(contactoDTO.getEmail());
    contacto.setMensaje(contactoDTO.getMensaje());

    // 2. Guardar en la base de datos
    Contacto contactoGuardado = contactoRepository.save(contacto);

    // 3. Retornar el DTO con la info guardada
    return contactoDTO;
  }

  @Override
  public List<ContactoDTO> listarMensajes() {
    // Obtener todos los mensajes y convertirlos a DTOs
    return contactoRepository.findAll().stream()
      .map(contacto -> {
        ContactoDTO dto = new ContactoDTO();
        dto.setNombre(contacto.getNombre());
        dto.setEmail(contacto.getEmail());
        dto.setMensaje(contacto.getMensaje());
        return dto;
      })
      .collect(Collectors.toList());
  }
}
