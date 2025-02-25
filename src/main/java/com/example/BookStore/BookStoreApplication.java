package com.example.BookStore;

import com.example.BookStore.Model.Address;
import com.example.BookStore.Model.Customer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}
	@GetMapping
	public List<Customer> hello(){
			return List.of(new Customer(
					"Joey",
					"Tolentino",
					"09958769874",
					new Address(485, "Thursday", "Poblacion", "Mandaluyong"),
					22)

			);
	}
}
