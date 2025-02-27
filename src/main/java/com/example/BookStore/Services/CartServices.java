package com.example.BookStore.Services;

import com.example.BookStore.Model.Book;
import com.example.BookStore.Model.Cart;
import com.example.BookStore.Repository.CartRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CartServices {

    private final CartRepository cartRepo;

    public CartServices(CartRepository cartRepo) {
        this.cartRepo = cartRepo;
    }

    public Optional<Cart> get(Long id) {
        return this.cartRepo.findById(id.intValue());
    }

    public Iterable<Cart> getAll(){
        return this.cartRepo.findAll();
    }

    public  Cart create(Cart cart){
        return this.cartRepo.save(cart);
    }
}
