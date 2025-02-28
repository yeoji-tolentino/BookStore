package com.example.BookStore.Services;

import com.example.BookStore.Model.*;
import com.example.BookStore.Repository.OrderItemRepository;
import com.example.BookStore.Repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServices {
    private final OrderRepository orderRepository;
    private final OrderItemRepository orderItemRepository;

    public OrderServices(OrderRepository orderRepository, OrderItemRepository orderItemRepository) {
        this.orderRepository = orderRepository;
        this.orderItemRepository = orderItemRepository;
    }

    public Iterable<Order> getAll(){
        return this.orderRepository.findAll();
    }

    public  Order create(Order order){
        return this.orderRepository.save(order);
    }

    public Optional<Order> get(Long id) {
        return this.orderRepository.findById(id);
    }

    public Optional<Order> getByEmail(Long id) {
        return this.orderRepository.findById(id);
    }

    public List<OrderItem> createOrderItem(Order order, Book book, int qty) {
        System.out.println("Inside Service: " + book.getBook_id());
        OrderItem orderItem = new OrderItem(order, book, order.getCustomer(), qty);

        orderItem.setBook(book); // Make sure book is set
        orderItem.setCustomer(order.getCustomer());
        orderItem.setOrder(order);
        orderItem.setQty(qty);
        orderItemRepository.save(orderItem);
        orderItemRepository.save(orderItem);
        return orderItemRepository.findByOrder(order);
    }

    public List<Order> getOrdersByCustomerId(Long customerId) {

        return orderRepository.findByCustomerId(customerId);
    }
}
