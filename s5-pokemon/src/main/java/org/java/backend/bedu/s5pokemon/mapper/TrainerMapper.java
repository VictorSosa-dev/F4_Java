package org.java.backend.bedu.s5pokemon.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapping;

import org.java.backend.bedu.s5pokemon.dto.CreateTrainerDTO;
import org.java.backend.bedu.s5pokemon.dto.TrainerDTO;
import org.java.backend.bedu.s5pokemon.model.Trainer;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface TrainerMapper {

    TrainerDTO toDTO(Trainer model);

    @Mapping(target = "id", ignore = true)
    Trainer toModel(CreateTrainerDTO dto);

}
