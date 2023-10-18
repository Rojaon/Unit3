package com.example.HW.library.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    private String usn;
    private String name;


    @ManyToMany
    @JoinTable(
            name = "student_book",
            joinColumns = @JoinColumn(name = "student_usn"),
            inverseJoinColumns = @JoinColumn(name = "book_isbn")
    )
    private List<Book> books;


    public String getUsn() {
        return usn;
    }

    public void setUsn(String usn) {
        this.usn = usn;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(List<Book> books) {
        this.books = books;
    }
}
