package org.bedu.spoty.controller;

import lombok.extern.slf4j.Slf4j;
import org.bedu.spoty.dto.ErrorDTO;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDTO handleValidationException(MethodArgumentNotValidException e){
        List<FieldError> fieldErrors = e.getBindingResult().getFieldErrors();
        List<String> errors = fieldErrors.stream()
                .map(fieldError -> fieldError.getField() + ": " + fieldError.getDefaultMessage())
                .toList();
        return new ErrorDTO("ERR_VALIDATION", "Error de validación", errors);
    }

    @ExceptionHandler(Exception.class)
    public ErrorDTO unknownError(Exception e){
        log.error("Error desconocido", e);
        return new ErrorDTO("ERR_UNKNOWN", "Error desconocido", e.getMessage());
    }

}
