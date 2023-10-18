package com.example.HW.library.repository;

import com.example.HW.library.model.Author;
import com.example.HW.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Integer> {


}
