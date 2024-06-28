package com.clinident.security.persistence.dto.auth;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class LoginRequest {

    @NotBlank(message = "Email field cannot be null")
    private String email;

    @NotBlank(message = "Password field cannot be null")
    private String password;

}
