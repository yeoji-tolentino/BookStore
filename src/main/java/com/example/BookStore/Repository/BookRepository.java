package com.example.BookStore.Repository;

import com.example.BookStore.Model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer> {
}
