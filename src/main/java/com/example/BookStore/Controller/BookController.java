package com.example.BookStore.Controller;

import com.example.BookStore.Model.Address;
import com.example.BookStore.Model.Book;
import com.example.BookStore.Model.Cart;
import com.example.BookStore.Model.Customer;
import com.example.BookStore.Services.BookServices;
import com.example.BookStore.Services.CartServices;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;

import java.security.Principal;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/homepage")
public class BookController {
    private final BookServices bookServices;
    private final CartServices cartServices;

    public BookController(final BookServices bookServices, CartServices cartServices){
        this.bookServices = bookServices;
        this.cartServices = cartServices;
    }

    @GetMapping
    public String getBooks(Model model, Principal principal) {
        Iterable<Book> books = bookServices.getAll();
        model.addAttribute("books", books);

        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
            Iterable<Cart> carts = this.cartServices.getAll();

            model.addAttribute("carts", carts);

            System.out.println("User is logged in: " + username);
            System.out.println("Carts: " + carts);
        } else {
            System.out.println("No user is logged in.");
        }
        return "index";
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
    public ResponseEntity<Book> createBook(@Valid @ModelAttribute Book book){
        Book savedBook = this.bookServices.create(book);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .header("Location", "api/products" + savedBook.getBook_id())
                .body(savedBook);
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam(value = "keyword", required = false) String keyword, Model model, Principal principal) {
        List<Book> books;
        if (keyword == null || keyword.trim().isEmpty()) {
            books = (List<Book>) bookServices.getAll();
        } else {
            books = bookServices.searchBooks(keyword);
        }

        if (principal != null) {
            String username = principal.getName();
            model.addAttribute("username", username);
            Iterable<Cart> carts = this.cartServices.getAll();

            model.addAttribute("carts", carts);

            System.out.println("User is logged in: " + username);
            System.out.println("Carts: " + carts);
        } else {
            System.out.println("No user is logged in.");
        }

        model.addAttribute("books", books);
        return "index";
    }

    @GetMapping("/api/search")
    public ResponseEntity<List<Book>> searchAPIBooks(@RequestParam String keyword) {
        List<Book> books = bookServices.searchBooks(keyword);
        return ResponseEntity.ok(books);
    }


}
