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

@Document(collection = "accounts")
public class Account {

    @Id
    private Integer accountID;
    private String email;
    private String password;
    private List<CartProduct> cart;

}
