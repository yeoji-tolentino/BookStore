package com.example.BookStore.Controller;

import com.example.BookStore.Repository.OrderRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderController {

    private final OrderRepository orderRepo;

    public OrderController(final OrderRepository orderRepo) {
        this.orderRepo = orderRepo;
    }
}
