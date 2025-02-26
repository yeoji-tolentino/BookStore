package com.example.BookStore.Controller;

import com.example.BookStore.Model.Address;
import com.example.BookStore.Model.Book;
import com.example.BookStore.Model.Customer;
import com.example.BookStore.Repository.BookRepository;
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
    private final BookRepository bookRepo;

    public BookController(final BookRepository bookRepo){
        this.bookRepo = bookRepo;
    }

    @GetMapping
    public Iterable<Book> getBooks(){
        return this.bookRepo.findAll();
    }

    @GetMapping("/view/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable Long bookId){
        Optional<Book> bookFound = this.bookRepo.findById(bookId.intValue());
        Book book = bookFound.get();

        if(!bookFound.isPresent()){
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "api/products" + book.getBook_id())
                .body(book);
    }

    @PostMapping("/create")
    public ResponseEntity<Book> createBook(@Valid @RequestBody Book book){
        Book savedBook = this.bookRepo.save(book);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "api/products" + savedBook.getBook_id())
                .body(savedBook);
    }

}
