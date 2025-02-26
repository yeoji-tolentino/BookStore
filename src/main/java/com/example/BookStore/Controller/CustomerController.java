package com.example.BookStore.Controller;

import com.example.BookStore.Model.Address;
import com.example.BookStore.Model.Customer;
import com.example.BookStore.Repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {
    private final CustomerRepository customerRepo;

    public CustomerController(final CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

//    @GetMapping("/customers")
//    public List<Customer> hello(){
//        return
//    }
}
