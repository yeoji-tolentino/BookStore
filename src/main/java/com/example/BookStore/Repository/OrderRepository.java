package com.example.BookStore.Repository;

import com.example.BookStore.Model.Cart;
import com.example.BookStore.Model.Order;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order,Long> {
    Optional<Order> findById(Long order_id);
    List<Order> findByCustomerId(Long customerId);
}
