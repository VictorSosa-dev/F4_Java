package com.java.eshop.s4.repository;

import com.java.eshop.s4.model.Product;
import org.springframework.stereotype.Repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {

    private long currentId;

    private List<Product> products;

    public ProductRepository() {
        currentId = 1;
        products = new LinkedList<>();
    }

    public List<Product> getAll() {
        return products;
    }

    // version senior
    // Optional = null Safe, es decir, evitamos usar null directamente
    public Optional<Product> getById(long id) {
        return products.stream()
                .filter(p -> p.getId() == id)
                .findFirst();
    }
    // version junior
    /*public Product getById(long id) {
        Product data = null;
        for (Product p : products) {
            if (p.getId() == id) {
                data = p;
                break;
            }
        }
        return data;
    }*/

    public Product save(Product data) {
        data.setId(++currentId);
        products.add(data);
        return data;
    }

    public void update(Product data) {
        Optional<Product> entry = getById(data.getId());
        if (!entry.isPresent()) {
            return;
        }

        Product product = entry.get();

        if (data.getName() != null) {
            product.setName(data.getName());
        }

        if (data.getQuantity() > 0) {
            product.setQuantity(data.getQuantity());
        }

        if (data.getPrice() > 0) {
            product.setPrice(data.getPrice());
        }
    }
}
