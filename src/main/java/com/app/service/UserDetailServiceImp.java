package com.app.service;

import com.app.entity.Cliente;
import com.app.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImp implements UserDetailsService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Cliente cliente = clienteRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario con email " + email + " no encontrado"));

        List<SimpleGrantedAuthority> authorityList = new ArrayList<>();

        authorityList.add(new SimpleGrantedAuthority("ROLE_" + cliente.getRol().name()));

        return new User(cliente.getEmail(),
                cliente.getPassword(),
                cliente.getIsEnabled(),
                cliente.getAccountNoExpired(),
                cliente.getCredentialsNoExpired(),
                cliente.getAccountNoLocked(),
                authorityList
        );

    }
}
