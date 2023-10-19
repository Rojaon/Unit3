package com.example.HW.library.components;

import com.example.HW.library.model.Author;
import com.example.HW.library.model.Book;
import com.example.HW.library.model.Issue;
import com.example.HW.library.model.Student;
import com.example.HW.library.repository.AuthorRepository;
import com.example.HW.library.repository.BookRepository;
import com.example.HW.library.repository.IssueRepository;
import com.example.HW.library.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

@Component
public class Library {
    @Autowired
    AuthorRepository authorRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    IssueRepository issueRepository;

    public void createBookAndAuthor(String authorName, String authorEmail, Book book) {
        Author author = new Author(authorName,authorEmail,book);
        book.setAuthor(author);
        authorRepository.save(author);
    }

    public Issue createIssue(String usn, String studentName, String isbn) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        String today = dateFormat.format(date);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, 7);
        Date date2 = cal.getTime();
        String returnDate = dateFormat.format(date2);

        Optional<Book> bookOptional1 = bookRepository.findById(isbn);
        Student student = new Student(usn , studentName);
        Optional<Student> studentOpt = studentRepository.findById(usn);
        if(studentOpt.isEmpty()) {
            studentRepository.save(student);
        }else{
            student = studentOpt.get();
        }
        Issue issue = new Issue(today, returnDate , student , bookOptional1.get());
        issueRepository.save(issue);
        return issue;
    }
}
