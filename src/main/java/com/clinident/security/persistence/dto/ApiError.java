package com.clinident.security.persistence.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
@Getter
@Setter
public class ApiError {

    private String backendMessage;

    private String message;

    private String url;

    private String method;

    private LocalDateTime timestamp;
}
