package com.app.mapper;

import com.app.dto.MesaDTO;
import com.app.dto.ReservaDTO;
import com.app.entity.Reserva;
import org.springframework.stereotype.Component;

@Component
public class ReservaMapper {
    public ReservaDTO toDTO(Reserva reserva) {
        if (reserva == null) return null;
        return ReservaDTO.builder()
                .id(reserva.getId())
                .descripcion(reserva.getDescripcion())
                .fechaHora(reserva.getFechaHora())
                .cantidadPersonas(reserva.getCantidadPersonas())

                .idCliente(reserva.getCliente().getId())
                .idMesa(reserva.getMesa().getId())

                .nombreCliente(reserva.getCliente().getNombre())
                .numeroMesa(reserva.getMesa().getNumeroMesa())
                .build();
    }

    public Reserva toEntity(ReservaDTO reservaDTO) {
        if (reservaDTO == null) return null;
        return Reserva.builder()
                .id(reservaDTO.getId())
                .descripcion(reservaDTO.getDescripcion())
                .fechaHora(reservaDTO.getFechaHora())
                .cantidadPersonas(reservaDTO.getCantidadPersonas())
                .build();
    }
}
