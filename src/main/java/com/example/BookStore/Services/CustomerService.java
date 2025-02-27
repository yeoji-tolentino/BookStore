package com.example.BookStore.Services;

import com.example.BookStore.Model.Customer;
import com.example.BookStore.Repository.CustomerRepository;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {
    private final CustomerRepository customerRepo;

    public CustomerService(final CustomerRepository customerRepo) {
        this.customerRepo = customerRepo;
    }

    public Customer create(Customer customer){
        return this.customerRepo.save(customer);
    }
}
