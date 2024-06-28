package com.clinident.security.service.impl;

import com.clinident.security.exception.InvalidPasswordException;
import com.clinident.security.exception.UserNotFoundException;
import com.clinident.security.persistence.dto.auth.RegisterRequest;
import com.clinident.security.persistence.dto.UserRole;
import com.clinident.security.persistence.entities.User;
import com.clinident.security.persistence.repositories.UserRepository;
import com.clinident.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElseThrow(()-> new UserNotFoundException("User not found with id: "+id));
    }

    @Override
    public User createUser(RegisterRequest request) {

        validatePassword(request);

        User user = User.builder()
                .email(request.getEmail())
                .firstname(request.getFirstName())
                .lastname(request.getLastName())
                .password(passwordEncoder.encode(request.getPassword()))
                .userRole(UserRole.DOCTOR_ROLE)
                .build();

        userRepository.save(user);
        return user;
    }

    @Override
    public User findOneUserByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(()-> new UserNotFoundException("User not found with email: "+email));
    }

    private void validatePassword(RegisterRequest dto) {

        if(!StringUtils.hasText(dto.getPassword()) || !StringUtils.hasText(dto.getConfirmPassword())){
            throw new InvalidPasswordException("Passwords don't match");
        }

        if(!dto.getPassword().equals(dto.getConfirmPassword())){
            throw new InvalidPasswordException("Passwords don't match");
        }

    }


}
