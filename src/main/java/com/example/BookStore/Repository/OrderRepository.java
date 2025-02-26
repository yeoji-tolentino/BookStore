package com.example.BookStore.Repository;

import com.example.BookStore.Model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order,Integer> {
}
