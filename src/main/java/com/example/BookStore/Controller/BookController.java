package com.example.BookStore.Controller;

import com.example.BookStore.Model.Address;
import com.example.BookStore.Model.Book;
import com.example.BookStore.Model.Customer;
import com.example.BookStore.Services.BookServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookServices bookServices;

    public BookController(final BookServices bookServices){
        this.bookServices = bookServices;
    }

    @GetMapping
    public Iterable<Book> getBooks(){
        return this.bookServices.getAll();
    }

    @GetMapping("/view/{bookId}")
    public ResponseEntity<Book> viewBook(@PathVariable Long bookId){
        Optional<Book> bookFound = this.bookServices.get(bookId);

        if(bookFound.isEmpty()){
            return ResponseEntity.notFound().build();
        }

        Book book = bookFound.get();

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "api/products" + book.getBook_id())
                .body(book);
    }

    @PostMapping("/create")
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book){
        Book savedBook = this.bookServices.create(book);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "api/products" + savedBook.getBook_id())
                .body(savedBook);
    }

}
