package org.bedu.spoty.mapper;

import org.bedu.spoty.model.Interpretation;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface InterpretationMapper {

    // Los mapper no aceptan parámetros de tipo primitivo, por lo que se debe usar el tipo envolvente
    // en este caso, long -> Long
    @Mapping(source = "artistId", target = "id.artistId")
    @Mapping(source = "artistId", target = "artist.id")
    @Mapping(source = "songId", target = "id.songId")
    @Mapping(source = "songId", target = "song.id")
    Interpretation toModel(Long artistId, Long songId);

}
