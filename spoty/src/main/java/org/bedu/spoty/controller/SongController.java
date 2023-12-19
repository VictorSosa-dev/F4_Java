package org.bedu.spoty.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.bedu.spoty.dto.CreateSongDTO;
import org.bedu.spoty.dto.SongDTO;
import org.bedu.spoty.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Songs", description = "The Songs API")
@RestController
@RequestMapping("/song")
public class SongController {

    @Autowired
    private SongService service;

    @Operation(summary = "Get all songs")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<SongDTO> findAll(){
        return service.findAll();
    }

    @Operation(summary = "Create a new song")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SongDTO save(@Valid @RequestBody CreateSongDTO data){
        return service.save(data);
    }
}
