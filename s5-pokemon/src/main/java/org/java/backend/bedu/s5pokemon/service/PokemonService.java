package org.java.backend.bedu.s5pokemon.service;

import org.java.backend.bedu.s5pokemon.dto.CreatePokemonDTO;
import org.java.backend.bedu.s5pokemon.dto.PokemonDTO;
import org.java.backend.bedu.s5pokemon.mapper.PokemonMapper;
import org.java.backend.bedu.s5pokemon.model.Pokemon;
import org.java.backend.bedu.s5pokemon.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    @Autowired
    private PokemonMapper pokemonMapper;

    public List<PokemonDTO> findAll() {
        return pokemonRepository
                .findAll()
                .stream()
                .map(pokemonMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PokemonDTO save(CreatePokemonDTO data) {
        Pokemon entity = pokemonRepository
                .save(pokemonMapper.toModel(data));
        return pokemonMapper.toDTO(entity);
    }
}
