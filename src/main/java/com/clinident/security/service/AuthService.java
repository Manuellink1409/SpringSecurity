package com.clinident.security.service;

import com.clinident.security.persistence.dto.auth.LoginRequest;
import com.clinident.security.persistence.dto.auth.LoginResponse;
import com.clinident.security.persistence.dto.auth.RegisterRequest;
import com.clinident.security.persistence.dto.auth.RegisterResponse;

public interface AuthService {

    LoginResponse login(LoginRequest request);

    RegisterResponse register(RegisterRequest request);

    boolean validateToken(String jwt);
}
