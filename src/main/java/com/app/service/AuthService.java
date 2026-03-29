package com.app.service;

import com.app.dto.ClienteDTO;
import com.app.dto.LoginDTO;
import com.app.dto.RegisterDTO;
import com.app.entity.Cliente;
import com.app.entity.Rol;
import com.app.mapper.ClienteMapper;
import com.app.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthService implements IAuthService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    @Override
    public ClienteDTO create(RegisterDTO registerDTO) {
        Cliente cliente = clienteMapper.toEntity(registerDTO);
        cliente.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        cliente.setRol(Rol.CLIENTE);

        cliente.setIsEnabled(true);
        cliente.setAccountNoExpired(true);
        cliente.setAccountNoLocked(true);
        cliente.setCredentialsNoExpired(true);

        return clienteMapper.toDTO(clienteRepository.save(cliente));
    }

    @Override
    public ClienteDTO login(String email, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(email, password)
        );

        Cliente cliente = clienteRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
        return clienteMapper.toDTO(cliente);
    }

}
