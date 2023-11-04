package com.shopping_website.backend.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Getter
@Setter
@ToString

@Document(collection = "products")
public class Product {

    @Id
    private Integer productID;
    private String about;
    private String price;
    private String imgsrc;
    private List<String> bullets;

}
