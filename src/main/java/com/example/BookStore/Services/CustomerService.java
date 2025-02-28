package com.example.BookStore.Services;

import com.example.BookStore.Model.Customer;
import com.example.BookStore.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepo;

    public CustomerService(final CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer create(Customer customer){
        return this.customerRepo.save(customer);
    }

    public Optional<Customer> get(Long id) {
        return this.customerRepo.findById(id.intValue());
    }

    public Optional<Customer> getByEmail(String email) {
        return this.customerRepo.findByEmail(email);
    }
}
