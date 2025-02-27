package com.example.BookStore.Services;

import com.example.BookStore.Model.Cart;
import com.example.BookStore.Model.Order;
import com.example.BookStore.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderServices {
    private final OrderRepository orderRepository;

    public OrderServices(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Optional<Order> get(Long id) {
        return this.orderRepository.findById(id.intValue());
    }

    public Iterable<Order> getAll(){
        return this.orderRepository.findAll();
    }

    public  Order create(Order order){
        return this.orderRepository.save(order);
    }
}
