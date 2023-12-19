package org.bedu.spoty.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateArtistDTO {

    @NotBlank
    private String name;
}
