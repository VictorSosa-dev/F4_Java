package org.bedu.spoty.mapper;

import org.bedu.spoty.dto.ArtistDTO;
import org.bedu.spoty.dto.CreateArtistDTO;
import org.bedu.spoty.dto.UpdateArtistDTO;
import org.bedu.spoty.model.Artist;
import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
public interface ArtistMapper {

    ArtistDTO toDTO(Artist model);

    List<ArtistDTO> toDTO(List<Artist> model);

    @Mapping(target = "id", ignore = true)
    Artist toModel(CreateArtistDTO dto);

    @Mapping(target = "id", ignore = true)
    void update(@MappingTarget Artist artist, UpdateArtistDTO data);
}
