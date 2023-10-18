package com.example.HW.library.repository;

import com.example.HW.library.model.Book;
import com.example.HW.library.model.Issue;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IssueRepository extends JpaRepository<Issue, Integer> {

    @Query("SELECT i FROM Issue i JOIN Student s ON i.issueStudent = s WHERE s.usn = ?1 ")
    List<Issue> findByStudentsUsn(String usn);
}
