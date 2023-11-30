package org.java.backend.bedu.s5pokemon.repository;

import org.java.backend.bedu.s5pokemon.model.Pokemon;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PokemonRepository extends CrudRepository<Pokemon, Long> {

    List<Pokemon> findAll();
}
