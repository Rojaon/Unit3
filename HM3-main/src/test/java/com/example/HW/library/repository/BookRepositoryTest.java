package com.example.HW.library.repository;

import com.example.HW.library.model.Book;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class BookRepositoryTest {
    @Autowired
    BookRepository bookRepository;

    @BeforeEach
    public void setUp() {

        Book B2 = new Book("456","Disney","cardiology",1);

        bookRepository.save(B2);
    }
    @Test
    void findBooksByCategory() {
        List<Book> books = bookRepository.findBooksByCategory("cardiology");

        assertFalse(books.isEmpty());
    }
}