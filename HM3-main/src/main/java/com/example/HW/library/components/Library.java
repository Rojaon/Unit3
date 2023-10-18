package com.example.HW.library.components;

import com.example.HW.library.model.Author;
import com.example.HW.library.model.Book;
import com.example.HW.library.repository.AuthorRepository;
import com.example.HW.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class Library {              //methods
    @Autowired
    AuthorRepository authorRepository;

    public void createBookAndAuthor(String authorName, String authorEmail, Book book) {
        Author author = new Author(authorName,authorEmail,book);
        book.setAuthor(author);
        authorRepository.save(author);
    }
}
