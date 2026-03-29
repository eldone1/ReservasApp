package com.app.service;

import com.app.dto.ClienteDTO;
import com.app.dto.LoginDTO;
import com.app.dto.RegisterDTO;

public interface IAuthService {
    ClienteDTO create(RegisterDTO registerDTO);
    ClienteDTO login(String email, String password);
}
