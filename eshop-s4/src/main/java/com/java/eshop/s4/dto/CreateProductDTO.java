package com.java.eshop.s4.dto;

import lombok.*;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

/*
 * @Data
 * @Getter
 * @Setter
 * @ToString
 * @EqualsAndHashCode <-- Tener con conflictos con otras librerías, por Ej. JPA
 * @RequiredArgsConstructor
 *
 */
@Data
public class CreateProductDTO {

    @NotBlank
    private String name;

    @Min(1)
    private int quantity;

    @DecimalMin("0.0")
    private double price;

}
