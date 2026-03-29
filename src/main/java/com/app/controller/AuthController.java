package com.app.controller;

import com.app.dto.ClienteDTO;
import com.app.dto.LoginDTO;
import com.app.dto.RegisterDTO;
import com.app.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@AllArgsConstructor
@RequestMapping("api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginDTO loginDTO) {
        ClienteDTO clienteDTO = authService.login(loginDTO.getEmail(), loginDTO.getPassword());
        return ResponseEntity.ok("Usuario logeado correctamente");
    }

    @PostMapping("/registro")
    public ResponseEntity<ClienteDTO> crearUsuario(@RequestBody RegisterDTO registerDTO) {
        ClienteDTO creado = authService.create(registerDTO);
        return ResponseEntity.created(URI.create("/api/auth/" + creado.getId()))
                .body(creado);
    }
}
