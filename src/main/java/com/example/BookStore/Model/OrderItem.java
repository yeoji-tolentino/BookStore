package com.example.BookStore.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="order_items")
public class OrderItem {

    @Id
    @GeneratedValue
    private Long id;

    @ManyToOne
    @NotNull(message = "Cannot find order id")
    private Order order;

    @ManyToOne
    @NotNull(message = "Cannot find book id")
    private Book book;

    @ManyToOne
    @NotNull(message = "Cannot find customer id")
    private Customer customer;

    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity cannot be negative")
    private int qty;

    public OrderItem(){}

    public OrderItem(Order order, Book book, Customer customer, int qty) {
        this.order = order;
        this.book = book;
        this.customer = customer;
        this.qty = qty;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
