package com.clinident.security.controller;

import com.clinident.security.persistence.dto.LoginRequest;
import com.clinident.security.persistence.dto.LoginResponse;
import com.clinident.security.persistence.dto.RegisterRequest;
import com.clinident.security.persistence.dto.RegisterResponse;
import com.clinident.security.service.AuthService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody @Valid LoginRequest request){
        return ResponseEntity.ok().body(authService.login(request));
    }

    @PostMapping("/register")
    public ResponseEntity<RegisterResponse> register(@RequestBody @Valid RegisterRequest request){
        return ResponseEntity.ok().body(authService.register(request));
    }

}
