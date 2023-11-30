package org.java.backend.bedu.s5pokemon.controller;

import org.java.backend.bedu.s5pokemon.dto.CreatePokemonDTO;
import org.java.backend.bedu.s5pokemon.dto.PokemonDTO;
import org.java.backend.bedu.s5pokemon.service.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PokemonDTO> findAll() {
        return pokemonService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PokemonDTO save(@RequestBody CreatePokemonDTO data) {
        return pokemonService.save(data);
    }

}
