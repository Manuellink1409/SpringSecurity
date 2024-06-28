package com.clinident.security.exception;

import com.clinident.security.persistence.dto.ApiError;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handlerGenericException(Exception ex, HttpServletRequest request){
        ApiError apiError  = new ApiError();
        apiError.setBackendMessage(ex.getLocalizedMessage());
        apiError.setUrl(request.getRequestURL().toString());
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setMessage("Internal Server Error");
        apiError.setMethod(request.getMethod());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException ex, HttpServletRequest request){
        ApiError apiError  = new ApiError();
        apiError.setBackendMessage(ex.getLocalizedMessage());
        apiError.setUrl(request.getRequestURL().toString());
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setMessage("Error en la peticion enviada");
        apiError.setMethod(request.getMethod());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }

    @ExceptionHandler(InvalidPasswordException.class)
    public ResponseEntity<?> invalidPasswordException(InvalidPasswordException ex, HttpServletRequest request){
        ApiError apiError  = new ApiError();
        apiError.setBackendMessage(ex.getLocalizedMessage());
        apiError.setUrl(request.getRequestURL().toString());
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setMessage("Doesn´t match password");
        apiError.setMethod(request.getMethod());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> invalidPasswordException(UserNotFoundException ex, HttpServletRequest request){
        ApiError apiError  = new ApiError();
        apiError.setBackendMessage(ex.getLocalizedMessage());
        apiError.setUrl(request.getRequestURL().toString());
        apiError.setTimestamp(LocalDateTime.now());
        apiError.setMessage("User not found");
        apiError.setMethod(request.getMethod());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(apiError);
    }



}
