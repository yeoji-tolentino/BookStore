package com.example.BookStore.Repository;

import com.example.BookStore.Model.Cart;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends CrudRepository<Cart,Long> {

    Optional<Cart> findById(Long id);
    List<Cart> findByCustomerId(Long customerId);
}
