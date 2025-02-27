package com.example.BookStore.Controller;

import com.example.BookStore.Model.Address;
import com.example.BookStore.Model.Customer;
import com.example.BookStore.Repository.CustomerRepository;
import com.example.BookStore.Services.CustomerService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/")
public class CustomerController {
    private final CustomerService customerService;

    public CustomerController(final CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("/register")
    public ResponseEntity<Customer> createBook(@Valid @PathVariable Customer customer){
        Customer savedCustomer = this.customerService.create(customer);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "api/products" + savedCustomer.getCustomer_id())
                .body(savedCustomer);
    }
}
