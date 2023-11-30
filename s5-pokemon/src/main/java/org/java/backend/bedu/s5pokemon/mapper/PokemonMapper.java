package org.java.backend.bedu.s5pokemon.mapper;

import org.java.backend.bedu.s5pokemon.dto.CreatePokemonDTO;
import org.java.backend.bedu.s5pokemon.dto.PokemonDTO;
import org.java.backend.bedu.s5pokemon.model.Pokemon;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface PokemonMapper {

    PokemonDTO toDTO(Pokemon model);

    @Mapping(target = "id", ignore = true)
    Pokemon toModel(CreatePokemonDTO dto);
}
