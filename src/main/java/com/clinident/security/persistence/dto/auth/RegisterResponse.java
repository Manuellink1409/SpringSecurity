package com.clinident.security.persistence.dto.auth;

import com.clinident.security.persistence.dto.UserRole;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class RegisterResponse {

    private Long id;

    private String fullname;

    private String email;

    private UserRole role;

    private String jwt;

}
