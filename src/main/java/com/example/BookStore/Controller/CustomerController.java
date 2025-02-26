package com.example.BookStore.Controller;

import com.example.BookStore.Model.Address;
import com.example.BookStore.Model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustomerController {

    @GetMapping("/customers")
    public List<Customer> hello(){
        return List.of(new Customer(
                "Joey",
                "Tolentino",
                "09958769874",
                new Address(485, "Thursday", "Poblacion", "Mandaluyong"),
                22)

        );
    }
}
