package com.shopping_website.backend.services;

import com.shopping_website.backend.models.Product;
import com.shopping_website.backend.repos.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public String saveProduct(Product product) {
        productRepository.save(product);
        return "Data Posted";
    }

    public String saveProducts(List<Product> products) {
        productRepository.saveAll(products);
        return "Data Posted";
    }

}
