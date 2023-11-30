package org.java.backend.bedu.s5pokemon.service;

import org.java.backend.bedu.s5pokemon.dto.TrainerDTO;
import org.java.backend.bedu.s5pokemon.mapper.TrainerMapper;
import org.java.backend.bedu.s5pokemon.model.Trainer;
import org.java.backend.bedu.s5pokemon.repository.TrainerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.java.backend.bedu.s5pokemon.dto.CreateTrainerDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainerService {

    @Autowired
    private TrainerRepository repository;

    @Autowired
    private TrainerMapper mapper;

    public List<TrainerDTO> findAll() {
        List<Trainer> data = repository.findAll();
        return data.stream().map(mapper::toDTO).collect(Collectors.toList());
    }

    public TrainerDTO save(CreateTrainerDTO data) {
        Trainer entity = repository.save(mapper.toModel(data));
        return mapper.toDTO(entity);
    }
}
