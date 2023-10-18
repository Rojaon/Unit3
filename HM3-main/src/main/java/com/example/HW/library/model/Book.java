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
//
//    public String getBookISBN() {
//        return bookISBN;
//    }
//
//    public void setBookISBN(String bookISBN) {
//        this.bookISBN = bookISBN;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getCategory() {
//        return category;
//    }
//
//    public void setCategory(String category) {
//        this.category = category;
//    }
//
//    public Integer getQuantity() {
//        return quantity;
//    }
//
//    public void setQuantity(Integer quantity) {
//        this.quantity = quantity;
//    }
//
//    public Author getAuthor() {
//        return author;
//    }
//
//    public void setAuthor(Author author) {
//        this.author = author;
//    }
//
//    @Override
//    public String toString() {
//        return "Book : \n" +
//                "bookISBN :" + bookISBN +"\n" +
//                "title : " + title + "\n"  +
//                "category : " + category + "\n"  +
//                "quantity : " + quantity
//                ;
//    }
}

