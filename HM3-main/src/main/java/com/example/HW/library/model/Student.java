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


    @OneToMany
    @JoinTable(
            name = "student_book",
            joinColumns = @JoinColumn(name = "student_usn"),
            inverseJoinColumns = @JoinColumn(name = "book_isbn")
    )
    private List<Book> books;

    public Student(String usn, String name) {
        this.usn = usn;
        this.name = name;
    }


    public String getName() {
        return name;
    }

}
