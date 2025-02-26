package com.example.BookStore.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

@Entity
@Table(name="carts")
public class Cart {

    @Id
    @GeneratedValue
    private Long cart_id;

    @NotNull(message = "Cannot find book id")
    private Long book_it;

    @NotNull(message = "Cannot find customer id")
    private Long customer_it;

    @NotNull(message = "Quantity is required")
    @Min(value = 0, message = "Quantity cannot be negative")
    private int qty;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Cart(){

    }

    public Cart(Long book_it, Long customer_it, int qty) {
        this.book_it = book_it;
        this.customer_it = customer_it;
        this.qty = qty;
        //initilize created and updated to date now when created
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }

    public Long getCart_id() {
        return cart_id;
    }

    public void setCart_id(Long cart_id) {
        this.cart_id = cart_id;
    }

    public Long getBook_it() {
        return book_it;
    }

    public void setBook_it(Long book_it) {
        this.book_it = book_it;
    }

    public Long getCustomer_it() {
        return customer_it;
    }

    public void setCustomer_it(Long customer_it) {
        this.customer_it = customer_it;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(LocalDateTime updated_at) {
        this.updated_at = updated_at;
    }
}
