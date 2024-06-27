package com.clinident.security.service;

import com.clinident.security.persistence.dto.RegisterRequest;
import com.clinident.security.persistence.entities.User;

public interface UserService {

    User getUserById(Long id);

    User createUser(RegisterRequest request);

    User findOneUserByEmail(String email);
}
