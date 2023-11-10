package com.shopping_website.backend.services;

import com.shopping_website.backend.models.Account;
import com.shopping_website.backend.models.CartProduct;
import com.shopping_website.backend.repos.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getOneAccount(String email) {
        return accountRepository.findAccountByEmail(email);
    }

    public String addAccount(Account account) {
        accountRepository.save(account);
        return "Account Created";
    }

    public String addToCart(String email, CartProduct cartProduct) {
        Account account = accountRepository.findAccountByEmail(email);
        List<CartProduct> accountCart = account.getCart();

        accountCart.add(cartProduct);

        account.setCart(accountCart);

        accountRepository.save(account);

        return "Item Added to Cart";
    }

    public String deleteFromCart(String email, List<Integer> index) {

        Account account = accountRepository.findAccountByEmail(email);
        List<CartProduct> accountCart = account.getCart();

        index.sort((a,b) -> b - a);

        for (int i: index) {
            accountCart.remove(i);
        }

        account.setCart(accountCart);
        accountRepository.save(account);

        return "Deleted Successfully";
    }
}
