package org.bedu.spoty.service;

import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.bedu.spoty.dto.*;
import org.bedu.spoty.exception.ArtistNotFoundException;
import org.bedu.spoty.mapper.ArtistMapper;
import org.bedu.spoty.mapper.SongMapper;
import org.bedu.spoty.model.Artist;
import org.bedu.spoty.repository.ArtistRepository;
import org.bedu.spoty.repository.InterpretationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArtistService {
    private ArtistRepository repository;

    private ArtistMapper mapper;

    private InterpretationRepository interpretationRepository;

    private SongMapper songMapper;

    @Autowired
    public ArtistService(ArtistRepository repository, ArtistMapper mapper,
                         InterpretationRepository interpretationRepository,
                         SongMapper songMapper) {
        this.repository = repository;
        this.mapper = mapper;
        this.interpretationRepository = interpretationRepository;
        this.songMapper = songMapper;
    }

    public List<ArtistDTO> findAll(){
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public ArtistDTO save(CreateArtistDTO data) {
        Artist artist = mapper.toModel(data);
        return mapper.toDTO(repository.save(artist));
    }

    public List<SongDTO> findAllSongs(long artistId) {
        return songMapper.toDTO(repository.findAllSongsByArtistId(artistId));
    }

    public void update(long artistId, UpdateArtistDTO data) throws ArtistNotFoundException {
        Optional<Artist> result = repository.findById(artistId);

        if (!result.isPresent()) {
            throw new ArtistNotFoundException(artistId);
        }

        Artist artist = result.get();
        // Aplicar los cambios al artista
        mapper.update(artist, data);

        repository.save(artist);

    }
}
