package com.example.BookStore.Controller;

import com.example.BookStore.Repository.CartRepository;

public class CartController {
    private final CartRepository cartRepo;

    public CartController(final CartRepository cartRepo) {
        this.cartRepo = cartRepo;
    }
}
