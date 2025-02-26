package com.example.BookStore.Model;

import java.time.LocalDateTime;

public class Order {
    private Long order_id;
    private Long customer_id;
    private double total_price;

    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Order(Long customer_it, double total_price) {
        this.customer_id = customer_it;
        this.total_price = total_price;
        //initilize created and updated to date now when created
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }

    public Long getOrder_it() {
        return order_id;
    }

    public void setOrder_it(Long order_it) {
        this.order_id = order_it;
    }


    public Long getCustomer_it() {
        return customer_id;
    }

    public void setCustomer_it(Long customer_it) {
        this.customer_id = customer_it;
    }

    public double getTotal_price() {
        return total_price;
    }

    public void setTotal_price(double total_price) {
        this.total_price = total_price;
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
