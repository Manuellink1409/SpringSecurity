package com.clinident.security.service;

import com.clinident.security.persistence.dto.LoginRequest;
import com.clinident.security.persistence.dto.LoginResponse;
import com.clinident.security.persistence.dto.RegisterRequest;
import com.clinident.security.persistence.dto.RegisterResponse;

public interface AuthService {

    LoginResponse login(LoginRequest request);

    RegisterResponse register(RegisterRequest request);

}
