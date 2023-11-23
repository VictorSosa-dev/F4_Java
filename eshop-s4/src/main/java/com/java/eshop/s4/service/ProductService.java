package com.java.eshop.s4.service;

import com.java.eshop.s4.dto.CreateProductDTO;
import com.java.eshop.s4.dto.ProductDTO;
import com.java.eshop.s4.model.Product;
import com.java.eshop.s4.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public List<ProductDTO> getAll() {
        List<Product> products = repository.getAll();

        List<ProductDTO> data = new LinkedList<>();
        for (Product product : products) {
            data.add(convertToDTO(product));
        }

        return data;
    }

    public ProductDTO save(CreateProductDTO data) {
        Product model = convertToModel(data);
        return convertToDTO(repository.save(model));
    }

    private Product convertToModel(CreateProductDTO data) {
        return new Product(
                0,
                data.getName(),
                data.getQuantity(),
                data.getPrice()
        );
    }

    private ProductDTO convertToDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getQuantity(),
                product.getPrice()
        );
    }

    private Product convertToModel(ProductDTO dto) {
        return new Product(
                dto.getId(),
                dto.getName(),
                dto.getQuantity(),
                dto.getPrice()
        );
    }
}
