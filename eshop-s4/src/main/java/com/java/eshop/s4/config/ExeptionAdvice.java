package com.java.eshop.s4.config;

import com.java.eshop.s4.dto.ErrorDTO;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.lang.reflect.Field;
import java.util.LinkedList;
import java.util.List;

@RestControllerAdvice
public class ExeptionAdvice {

    // Este método se va a ejecutar cuando se detecten errores de validación
    // es decir, cuando se envíen datos que no cumplan con las restricciones
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorDTO validationErrors(MethodArgumentNotValidException ex) {
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        List<String> errors = new LinkedList<>();

        //Extraer los errores de validación de la excepción
        for (FieldError fieldError : fieldErrors) {
            errors.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
        }
        return  new ErrorDTO(
                "ERR_VALID",
                "Hubo un error al validar los datos",
                errors.toString()
        );
    }

}
