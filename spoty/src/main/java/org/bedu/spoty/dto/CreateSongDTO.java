package org.bedu.spoty.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateSongDTO {

    @Schema(description = "Nombre de la canción", example = "La bamba")
    @NotBlank
    private String name;
    @Schema(description = "Duración de la canción en segundos", example = "120")
    @Min(1)
    private int duration;
}
