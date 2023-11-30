package org.java.backend.bedu.s5pokemon.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateTrainerDTO {

    @NotBlank
    private String name;
}
