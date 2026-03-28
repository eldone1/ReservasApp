package com.app.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClienteDTO {

    private Long id;
    private String nombre;
    private String email;
    private List<ReservaDTO> reservas;
}
