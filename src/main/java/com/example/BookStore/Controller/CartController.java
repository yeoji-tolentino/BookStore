package com.example.BookStore.Controller;

import com.example.BookStore.Model.Cart;
import com.example.BookStore.Repository.CartRepository;
import com.example.BookStore.Services.CartServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartServices cartServices;

    public CartController(final CartServices cartServices) {
        this.cartServices = cartServices;
    }

    @GetMapping
    public Iterable<Cart> getCarts(@PathVariable Long cartId){
        return this.cartServices.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<Cart> createBook(@Valid @RequestBody Cart cart){
        Cart savedCart = this.cartServices.create(cart);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "api/products" + savedCart.getCart_id())
                .body(savedCart);
    }

    @DeleteMapping("/delete/{cartId}")
    public ResponseEntity<Void> createBook(@PathVariable Long cart_id){
        //checks if the cart exists in the data.
        Optional<Cart> savedCart = this.cartServices.get(cart_id);
        if(savedCart.isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .header("Location", "api/products" + cart_id)
                    .build();
        }
        return ResponseEntity.notFound().build();
    }

}
