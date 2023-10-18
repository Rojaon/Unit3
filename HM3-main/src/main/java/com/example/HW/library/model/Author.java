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


        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }
    }


