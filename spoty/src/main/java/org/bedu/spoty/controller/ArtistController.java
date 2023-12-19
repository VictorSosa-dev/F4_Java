package org.bedu.spoty.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.bedu.spoty.dto.*;
import org.bedu.spoty.exception.ArtistNotFoundException;
import org.bedu.spoty.model.Artist;
import org.bedu.spoty.service.ArtistService;
import org.bedu.spoty.service.InterpretationService;
import org.hibernate.sql.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Artists", description = "The Artists API")
@RestController
@RequestMapping("/artist")
public class ArtistController {

    @Autowired
    private ArtistService service;

    @Autowired
    private InterpretationService interpretationService;

    @Operation(summary = "Get all artists")
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ArtistDTO> findAll(){
        return service.findAll();
    }

    @Operation(summary = "Create a new artist")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ArtistDTO save(@Valid @RequestBody CreateArtistDTO data){
        return service.save(data);
    }

    // Ejemplo: Agregar la cancion con id 3 al artista con id 1
    // POST /artist/1/songs
    // body: { "songId": 1 }
    @Operation(summary = "Add a song to an artist")
    @PostMapping("/{artistId}/songs")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addSong(@PathVariable long artistId, @Valid @RequestBody AddSongDTO data){
        interpretationService.addSong(artistId, data.getSongId());
    }

    @Operation(summary = "Get all songs from an artist")
    @GetMapping("/{artistId}/songs")
    @ResponseStatus(HttpStatus.OK)
    public List<SongDTO> findAllSongs(@PathVariable long artistId){
        return service.findAllSongs(artistId);
    }

    @Operation(summary = "Update an artist")
    @PutMapping("/{artistId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable long artistId, @Valid @RequestBody UpdateArtistDTO data) throws ArtistNotFoundException {
        service.update(artistId, data);
    }
}
