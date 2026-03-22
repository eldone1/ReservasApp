package com.app.repository;

import com.app.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    // Para Spring Security — buscar usuario por email al hacer login
    Optional<Cliente> findByEmail(String email);

    // Validar que no exista otro cliente con el mismo email al registrarse
    boolean existsByEmail(String email);
}
