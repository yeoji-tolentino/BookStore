package com.example.BookStore.Model;

import java.time.LocalDateTime;
import java.time.ZoneId;

public class Book {
    private Long book_id;
    private String title;
    private String author;
    private String description;
    private double price;
    private String category;
    private int stock;
    private int items_sold;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public Book(String title, String author, String description, double price, String category, int stock) {
        this.title = title;
        this.author = author;
        this.description = description;
        this.price = price;
        this.category = category;
        this.stock = stock;

        this.items_sold = 0;
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
    }

    public Long getBook_id() {
        return book_id;
    }

    public void setBook_id(Long book_id) {
        this.book_id = book_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getItems_sold() {
        return items_sold;
    }

    public void setItems_sold(int items_sold) {
        this.items_sold = items_sold;
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
