package com.app.dto;

import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservaDTO {
    private Long id;

    // Datos de la reserva
    private String descripcion;
    private LocalDateTime fechaHora;
    private Integer cantidadPersonas;

    // datos del cliente
    private Long idCliente;
    // datos de la mesa
    private Long idMesa;

    // datos para mostrar
    private String nombreCliente;
    private Integer numeroMesa;
}
