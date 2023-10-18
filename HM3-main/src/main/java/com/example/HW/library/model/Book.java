package com.example.HW.library.model;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Data
@NoArgsConstructor
public class Book {
    @Id
    private String bookISBN;
    private String title;
    private String category;
    private Integer quantity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    private Author author;

    @ManyToMany(mappedBy = "books")
    private List<Student> students;


    public Book(String bookISBN, String title, String category, Integer quantity) {
        this.bookISBN = bookISBN;
        this.title = title;
        this.category = category;
        this.quantity = quantity;
    }
}

