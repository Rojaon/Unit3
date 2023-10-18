package com.example.HW.library.components;

import com.example.HW.library.model.Book;
import com.example.HW.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Library {              //methods
    @Autowired
    BookRepository bookRepository;

    public Book findBookByTitle(String title) {
        Optional<Book> bookOptional = bookRepository.findBookByTitle(title);
        if (bookOptional.isPresent()) {
            return bookOptional.get();
        } else {
            throw new IllegalArgumentException("Book not found.");
        }
    }
}
