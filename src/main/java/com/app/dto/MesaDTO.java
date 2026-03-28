package com.app.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MesaDTO {
    private Long id;
    private Integer numeroMesa;
    private Integer capacidad;
    private Boolean disponible;
}
