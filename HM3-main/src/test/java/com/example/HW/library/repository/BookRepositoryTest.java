package com.example.HW.library.repository;

import com.example.HW.library.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

    @BeforeEach
    public void setUp() {

        Book B2 = new Book("456","Disnay","cardiology",1);

        Book savedBook2 = bookRepository.save(B2);
    }
    @Test
    void findBookByCategory() {
        Optional<Book> bookOptional1 = bookRepository.findBookByCategory("cardiology");
        System.out.println(bookOptional1.get());
    }
}