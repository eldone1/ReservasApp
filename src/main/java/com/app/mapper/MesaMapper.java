package com.app.mapper;

import com.app.dto.MesaDTO;
import com.app.entity.Mesa;
import org.springframework.stereotype.Component;

@Component
public class MesaMapper {

    public MesaDTO toDTO(Mesa mesa) {
        if(mesa == null) return null;
        return MesaDTO.builder()
                .id(mesa.getId())
                .numeroMesa(mesa.getNumeroMesa())
                .capacidad(mesa.getCapacidad())
                .disponible(mesa.getDisponible())
                .build();
    }

    public Mesa toEntity(MesaDTO mesaDTO) {
        if(mesaDTO == null) return null;
        return Mesa.builder()
                .id(mesaDTO.getId())
                .numeroMesa(mesaDTO.getNumeroMesa())
                .capacidad(mesaDTO.getCapacidad())
                .disponible(mesaDTO.getDisponible())
                .build();
    }
}
