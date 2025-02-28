package com.example.BookStore;

import com.example.BookStore.Model.Address;
import com.example.BookStore.Model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@Controller
@EnableCaching
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@GetMapping("/register_page")
	public String registerPage() {
		return "register";
	}

	@GetMapping("/login_page")
	public String loginPage() {
		return "login";
	}
}
