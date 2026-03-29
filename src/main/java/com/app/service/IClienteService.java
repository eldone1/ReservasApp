package com.app.service;

import com.app.dto.ClienteDTO;

import java.util.List;

public interface IClienteService {
    List<ClienteDTO> getClientes();
    ClienteDTO update(Long id, ClienteDTO clienteDTO);
    void delete(Long id);

}
