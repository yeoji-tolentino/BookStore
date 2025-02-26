package com.example.BookStore.Repository;

import com.example.BookStore.Model.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart,Integer> {
}
