package org.java.backend.bedu.s5pokemon.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.java.backend.bedu.s5pokemon.model.Type;

@Data
public class CreatePokemonDTO {

    @Min(1)
    @Max(907)
    private int number;

    @NotBlank
    private String name;

    @NotNull
    private Type type;
}
