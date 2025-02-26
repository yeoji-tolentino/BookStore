package com.example.BookStore.Controller;

import com.example.BookStore.Model.Address;
import com.example.BookStore.Model.Book;
import com.example.BookStore.Model.Customer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class BookController {

    @GetMapping
    public List<Book> hello(){
        return List.of(new Book(
                "How to be rich!",
                "Joey Pogi",
                "This is a book about finance and cash flow.",
                999,
                "Finance",
                20)

        );
    }

    @GetMapping("/book/{boodId}")
    public Book getBook(@PathVariable Long bookId){
//        return new Book();
    }
}
