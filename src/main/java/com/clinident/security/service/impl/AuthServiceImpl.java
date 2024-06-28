package com.clinident.security.service.impl;

import com.clinident.security.persistence.dto.auth.LoginRequest;
import com.clinident.security.persistence.dto.auth.LoginResponse;
import com.clinident.security.persistence.dto.auth.RegisterRequest;
import com.clinident.security.persistence.dto.auth.RegisterResponse;
import com.clinident.security.persistence.entities.User;
import com.clinident.security.service.AuthService;
import com.clinident.security.service.JwtService;
import com.clinident.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserService userService;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public LoginResponse login(LoginRequest request) {
        Authentication authentication = new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword());

        authenticationManager.authenticate(authentication);

        User user = userService.findOneUserByEmail(request.getEmail());

        String jwt = jwtService.generateToken(user,generateExtraClaims(user));

        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setToken(jwt);
        return loginResponse;
    }

    @Override
    public RegisterResponse register(RegisterRequest request) {
        User user = userService.createUser(request);
        RegisterResponse registerResponse = new RegisterResponse();
            registerResponse.setId(user.getId());
            registerResponse.setFullname(user.getFirstname()+" "+user.getLastname());
            registerResponse.setEmail(user.getEmail());
            registerResponse.setRole(user.getUserRole());

        String jwt = jwtService.generateToken(user,generateExtraClaims(user));
        registerResponse.setJwt(jwt);

        return registerResponse;
    }

    @Override
    public boolean validateToken(String jwt) {
        //Cualquier atributo del payload
        try {
            jwtService.extractEmail(jwt);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    private Map<String, Object> generateExtraClaims(User user) {

        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("firstname", user.getFirstname());
        extraClaims.put("lastname", user.getLastname());
        extraClaims.put("role", user.getUserRole());
        extraClaims.put("permissions", user.getAuthorities());

        return extraClaims;

    }

}
