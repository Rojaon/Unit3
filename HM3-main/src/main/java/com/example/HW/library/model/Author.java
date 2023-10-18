package com.example.HW.library.model;



import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;


    @Entity
    @Data
    @NoArgsConstructor
    public class Author{
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Integer authorId;
        private String name;
        private String email;
        @OneToOne(mappedBy = "author", cascade = CascadeType.ALL)
        private Book authorBook;

        public Author(String name , String email ,Book authorBook) {
            this.name=name;
            this.email=email;
            this.authorBook = authorBook;
        }

        public Integer getAuthorId() {
            return authorId;
        }

        public void setAuthorId(Integer authorId) {
            this.authorId = authorId;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Book getAuthorBook() {
            return authorBook;
        }

        public void setAuthorBook(Book authorBook) {
            this.authorBook = authorBook;
        }
    }


