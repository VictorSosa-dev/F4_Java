package org.bedu.spoty.service;

import org.bedu.spoty.dto.CreateSongDTO;
import org.bedu.spoty.dto.SongDTO;
import org.bedu.spoty.mapper.SongMapper;
import org.bedu.spoty.model.Song;
import org.bedu.spoty.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SongService {

    @Autowired
    private SongRepository repository;

    @Autowired
    private SongMapper mapper;

    public List<SongDTO> findAll(){
        return repository.findAll().stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public SongDTO save(CreateSongDTO data) {
        Song song = mapper.toModel(data);
        return mapper.toDTO(repository.save(song));
    }
}
