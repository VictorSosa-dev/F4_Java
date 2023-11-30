package com.java.eshop.s4.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {

    private long id;
    private String name;
    private int quantity;
    private double price;

}
