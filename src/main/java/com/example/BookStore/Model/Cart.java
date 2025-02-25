package com.example.BookStore.Model;

import java.time.LocalDateTime;

public class Cart {

    private Long cart_id;
    private Long book_it;
    private Long customer_it;
    private int qty;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Cart(Long book_it, Long customer_it, int qty) {
        this.book_it = book_it;
        this.customer_it = customer_it;
        this.qty = qty;

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
