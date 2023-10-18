package com.example.HW.library.repository;

import com.example.HW.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, String> {

    public Optional<Book> findBookByTitle(String title);

    List<Book> findAll();

    List<Book> findBooksByCategory(String category1);

    List<Book> findByStudentsUsn(String usn);

    @Query("SELECT b FROM Book b JOIN b.students s WHERE s.usn = :usn")
    List<Book> findBooksByStudentUsn(@Param("usn") String usn);

    @Query("SELECT b FROM Book b JOIN Author a ON b.author = a WHERE a.name = ?1 ")
    List<Book> findAllWhereNameParams(String name);

//    public Optional<Book> findBookByBookISBN(String bookISBN);

}
