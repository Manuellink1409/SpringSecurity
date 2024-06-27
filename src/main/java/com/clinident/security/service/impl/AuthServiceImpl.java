package com.clinident.security.service.impl;

import com.clinident.security.persistence.dto.LoginRequest;
import com.clinident.security.persistence.dto.LoginResponse;
import com.clinident.security.persistence.dto.RegisterRequest;
import com.clinident.security.persistence.dto.RegisterResponse;
import com.clinident.security.persistence.entities.User;
import com.clinident.security.service.AuthService;
import com.clinident.security.service.JwtService;
import com.clinident.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final JwtService jwtService;

    @Override
    public LoginResponse login(LoginRequest request) {
        return null;
    }

    @Override
    public RegisterResponse register(RegisterRequest request) {
        User user = userService.createUser(request);
        RegisterResponse registerResponse = new RegisterResponse();
            registerResponse.setId(user.getId());
            registerResponse.setFullname(user.getFirstname()+" "+user.getLastname());
            registerResponse.setEmail(user.getEmail());
            registerResponse.setRole(user.getUserRole());

        String jwt = jwtService.generateToken();
        registerResponse.setJwt(jwt);

        return registerResponse;
    }

}
