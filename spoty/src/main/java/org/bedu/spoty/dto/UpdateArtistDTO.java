package org.bedu.spoty.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class UpdateArtistDTO {

    @Schema(description = "Nombre del artista", example = "Ricardo Arjona")
    @NotBlank
    private String name;
}
