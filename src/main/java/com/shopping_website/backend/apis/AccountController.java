package com.shopping_website.backend.apis;

import com.shopping_website.backend.models.Account;
import com.shopping_website.backend.models.CartProduct;
import com.shopping_website.backend.services.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/get")
    public List<Account> getAllAccounts() {
        return accountService.getAllAccounts();
    }

    @GetMapping("/{email}")
    public Account getOneAccount(@PathVariable String email) {
        return accountService.getOneAccount(email);
    }

    @PostMapping("/add")
    public String addAccount(@RequestBody Account account) {
        return accountService.addAccount(account);
    }

    @PostMapping("/{email}/addtocart")
    public String addToCart(@PathVariable String email, @RequestBody CartProduct cartProduct) {
        return accountService.addToCart(email, cartProduct);
    }

    @PostMapping("/{email}/deletefromcart")
    public String deletetocart(@PathVariable String email, @RequestBody List<Integer>index) {
        return accountService.deleteFromCart(email, index);
    }

}
