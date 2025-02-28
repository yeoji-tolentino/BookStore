package com.example.BookStore.Controller;

import com.example.BookStore.Model.Order;
import jakarta.validation.Valid;
import java.util.List;

public class OrderRequest {
    @Valid
    private Order order;
    private List<Long> bookIds;
    private List<Integer> quantities;
    private int qty;

    // Constructors
    public OrderRequest() {}

    public OrderRequest(Order order, List<Long> bookIds, List<Integer> quantities, int qty) {
        this.order = order;
        this.bookIds = bookIds;
        this.quantities = quantities;
        this.qty = qty;
    }

    // Getters and Setters
    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public List<Long> getBookIds() {
        return bookIds;
    }

    public void setBookIds(List<Long> bookIds) {
        this.bookIds = bookIds;
    }

    public List<Integer> getQuantities() {
        return quantities;
    }

    public void setQuantities(List<Integer> quantities) {
        this.quantities = quantities;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
