package com.clinident.security.persistence.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterRequest {

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String confirmPassword;

}
