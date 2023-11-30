package com.java.eshop.s4.service;

import com.java.eshop.s4.dto.CreateProductDTO;
import com.java.eshop.s4.dto.ProductDTO;
import com.java.eshop.s4.mapper.ProductMapper;
import com.java.eshop.s4.model.Product;
import com.java.eshop.s4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProductService {

    private ProductRepository repository;

    private ProductMapper productMapper;

    @Autowired
    ProductService(ProductRepository repository, ProductMapper productMapper) {
        this.repository = repository;
        this.productMapper = productMapper;
    }

    public List<ProductDTO> getAll() {
        List<Product> products = repository.getAll();

        List<ProductDTO> data = new LinkedList<>();
        for (Product product : products) {
            data.add(productMapper.toDTO(product));
        }

        return data;
    }

    public ProductDTO save(CreateProductDTO data) {
        Product model = productMapper.toModel(data);
        return productMapper.toDTO(repository.save(model));
    }

}
