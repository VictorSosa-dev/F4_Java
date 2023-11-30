package org.java.backend.bedu.s5pokemon.repository;

import org.java.backend.bedu.s5pokemon.model.Trainer;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TrainerRepository extends CrudRepository<Trainer, Long> {
    List<Trainer> findAll();
}
