package com.app.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RegisterDTO {
    private String nombre;
    private String email;
    private String password;
}
