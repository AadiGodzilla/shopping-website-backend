package com.shopping_website.backend.apis;

import com.shopping_website.backend.models.Product;
import com.shopping_website.backend.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/getAll")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @PostMapping("/postOne")
    public String saveProduct(@RequestBody Product product) {
        return productService.saveProduct(product);
    }

    @PostMapping("/postMany")
    public String saveProducts(@RequestBody List<Product> products) {
        return productService.saveProducts(products);
    }

}
