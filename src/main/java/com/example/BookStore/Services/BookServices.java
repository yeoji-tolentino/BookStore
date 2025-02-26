package com.example.BookStore.Services;

import com.example.BookStore.Model.Book;
import com.example.BookStore.Repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServices {

    private final BookRepository bookRepo;

    public BookServices(BookRepository bookRepo) {
        this.bookRepo = bookRepo;
    }

    public Optional<Book> getBook(Long id) {

    }

}
