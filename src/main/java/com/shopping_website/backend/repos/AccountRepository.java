package com.shopping_website.backend.repos;

import com.shopping_website.backend.models.Account;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface AccountRepository extends MongoRepository<Account, Integer> {
    @Query("{'email' : ?0}")
    Account findAccountByEmail(String email);

    @Query("{'email' : ?0}, {$unset : {cart.?1 : 1}}")
    String deleteFromCart(String email, Integer index);
}
