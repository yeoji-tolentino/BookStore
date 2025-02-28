package com.example.BookStore.Controller;

import com.example.BookStore.Model.Cart;
import com.example.BookStore.Model.Customer;
import com.example.BookStore.Repository.CartRepository;
import com.example.BookStore.Services.CartServices;
import com.example.BookStore.Services.CustomerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")

public class CartController {
    private final CartServices cartServices;
    private final CustomerService customerService; // Fetch logged-in user

    public CartController(final CartServices cartServices, final CustomerService customerService) {
        this.cartServices = cartServices;
        this.customerService = customerService;
    }

    @GetMapping
    public Iterable<Cart> getCarts(){
        return this.cartServices.getAll();
    }

    @PostMapping("/add")
    public ResponseEntity<Cart> addToCart(@Valid @RequestBody Cart cart){

        System.out.println("This is cart   " + cart);
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getName();

        Optional<Customer> customerOpt = customerService.getByEmail(email);

        if (customerOpt.isEmpty()) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }

        Customer customer = customerOpt.get();
        cart.setCustomer(customer);

        Cart savedCart = this.cartServices.create(cart);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "api/products" + savedCart.getId())
                .body(savedCart);
    }

    @DeleteMapping("/delete/{cartId}")
    public ResponseEntity<Void> deleteCartItem(@PathVariable Long cartId){
        //checks if the cart exists in the data.
        boolean isCartDeleted = this.cartServices.deleteCart(cartId);
        if(isCartDeleted) {
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .header("Location", "api/products" + cartId)
                    .build();
        }
        return ResponseEntity.notFound().build();
    }

    //Find cart items by customer_id
    @GetMapping("/customer/{customerId}")
    public ResponseEntity<List<Cart>> getCartsByCustomerId(@PathVariable Long customerId) {
        return ResponseEntity.ok(cartServices.getCartsByCustomerId(customerId));
    }
}
