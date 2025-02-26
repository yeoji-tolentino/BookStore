package com.example.BookStore.Controller;

import com.example.BookStore.Model.Cart;
import com.example.BookStore.Repository.CartRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartRepository cartRepo;

    public CartController(final CartRepository cartRepo) {
        this.cartRepo = cartRepo;
    }

    @GetMapping
    public Iterable<Cart> getCarts(@PathVariable Long cartId){
        return this.cartRepo.findAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Cart> createBook(@Valid @RequestBody Cart cart){
        Cart savedCart = this.cartRepo.save(cart);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "api/products" + savedCart.getCart_id())
                .body(savedCart);
    }

    @DeleteMapping("/delete/{cartId")
    public ResponseEntity<Void> createBook(@PathVariable Long cart_id){
        //checks if the cart exists in the data.
        if(this.cartRepo.existsById(cart_id.intValue())) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .header("Location", "api/products" + cart_id)
                    .build();
        }
        return ResponseEntity.notFound().build();
    }

}
