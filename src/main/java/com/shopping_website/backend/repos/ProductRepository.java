package com.shopping_website.backend.repos;

import com.shopping_website.backend.models.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, Integer> {

}
