package com.java.eshop.s4.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ProductDTO {
    private long id;
    private String name;
    private int quantity;
    private double price;

}
