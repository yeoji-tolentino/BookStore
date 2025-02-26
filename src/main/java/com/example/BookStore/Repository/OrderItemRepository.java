package com.example.BookStore.Repository;

import com.example.BookStore.Model.OrderItem;
import org.springframework.data.repository.CrudRepository;

public interface OrderItemRepository extends CrudRepository<OrderItem,Integer> {
}
