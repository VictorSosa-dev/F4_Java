package org.java.backend.bedu.s5pokemon.controller;

import org.java.backend.bedu.s5pokemon.dto.CreateTrainerDTO;
import org.java.backend.bedu.s5pokemon.dto.TrainerDTO;
import org.java.backend.bedu.s5pokemon.service.TrainerService;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("trainers")
public class TrainerController {

    @Autowired
    private TrainerService service;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<TrainerDTO> findAll() {
        return service.findAll();
    }

    @PostMapping
    public TrainerDTO save(@Valid @RequestBody CreateTrainerDTO data) {
        return service.save(data);
    }
}
