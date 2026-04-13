package com.example.demo_backend.service;

import com.example.demo_backend.dto.PedidoDTO;

import java.util.List;

public interface PedidoService {


    List<PedidoDTO> obtenerTodas();

    PedidoDTO obtenerPorId(Long id);

    PedidoDTO guardar(PedidoDTO pedidoDTO);

    void eliminar(Long id);

}
