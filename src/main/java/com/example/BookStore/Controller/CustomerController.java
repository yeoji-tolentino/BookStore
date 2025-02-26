package com.example.BookStore.Controller;

import com.example.BookStore.Model.Address;
import com.example.BookStore.Model.Customer;
import com.example.BookStore.Repository.CustomerRepository;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    private final CustomerRepository customerRepo;

    public CustomerController(final CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> createBook(@Valid @PathVariable Customer customer){
        Customer savedCustomer = this.customerRepo.save(customer);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "api/products" + savedCustomer.getCustomer_id())
                .body(savedCustomer);
    }
}
