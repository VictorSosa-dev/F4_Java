package org.java.backend.bedu.s5pokemon.dto;

import lombok.Data;
import org.java.backend.bedu.s5pokemon.model.Type;

@Data
public class PokemonDTO {

    private long id;

    private int number;
    private String name;

    private Type type;
}
