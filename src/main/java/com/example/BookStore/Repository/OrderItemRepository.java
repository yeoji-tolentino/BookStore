package com.example.BookStore.Repository;

import com.example.BookStore.Model.Order;
import com.example.BookStore.Model.OrderItem;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderItemRepository extends CrudRepository<OrderItem,Integer> {

    List<OrderItem> findByOrder(Order order);
}
