package com.java.eshop.s4.controllers;

import com.java.eshop.s4.dto.CreateProductDTO;
import com.java.eshop.s4.dto.ProductDTO;
import com.java.eshop.s4.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ProductoController {

    @Autowired
    private ProductService service;

    @GetMapping("/products")
    public List<ProductDTO> getAll() {
        return service.getAll();
    }

    @PostMapping("/products")
    public ProductDTO save(@Valid @RequestBody CreateProductDTO data) {
        return service.save(data);
    }
}
