package com.app.mapper;

import com.app.dto.ClienteDTO;
import com.app.dto.ReservaDTO;
import com.app.entity.Cliente;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ClienteMapper {

    public ClienteDTO toDTO(Cliente cliente) {
        if (cliente == null) return null;
        List<ReservaDTO> reservas = cliente.getReservas().stream()
                .map(res -> ReservaDTO.builder()
                        .id(res.getId())
                        .fechaHora(res.getFechaHora())
                        .numeroMesa(res.getMesa().getNumeroMesa())
                        .build())
                .toList();
        return ClienteDTO.builder()
                .id(cliente.getId())
                .nombre(cliente.getNombre())
                .email(cliente.getEmail())
                .reservas(reservas)
                .build();
    }

    public Cliente ToEntity(ClienteDTO clienteDTO) {
        if (clienteDTO == null) return null;
        return Cliente.builder()
                .id(clienteDTO.getId())
                .nombre(clienteDTO.getNombre())
                .email(clienteDTO.getEmail())
                .build();

    }
}
