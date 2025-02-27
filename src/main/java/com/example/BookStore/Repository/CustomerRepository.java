package com.example.BookStore.Repository;

import com.example.BookStore.Model.Customer;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer,Integer> {

    Optional<Customer> findByEmail(String email);

}
