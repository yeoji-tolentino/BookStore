package com.example.BookStore.Model;

public class OrderItem {

    private Long order_item_id;
    private Long order_id;
    private long book_id;
    private long customer_id;
    private int qty;

    public OrderItem(Long order_id, long book_id, long customer_id, int qty) {
        this.order_id = order_id;
        this.book_id = book_id;
        this.customer_id = customer_id;
        this.qty = qty;
    }

    public Long getOrder_item_id() {
        return order_item_id;
    }

    public void setOrder_item_id(Long order_item_id) {
        this.order_item_id = order_item_id;
    }

    public Long getOrder_id() {
        return order_id;
    }

    public void setOrder_id(Long order_id) {
        this.order_id = order_id;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }

    public long getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(long customer_id) {
        this.customer_id = customer_id;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }
}
