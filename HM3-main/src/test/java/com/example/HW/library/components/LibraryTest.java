package com.example.HW.library.components;

import com.example.HW.library.model.Issue;
import com.example.HW.library.repository.IssueRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LibraryTest {

    @Autowired
    IssueRepository issueRepository;

    @Autowired
    Library library;

    @Test
    void createIssue_valid_create() {
        Issue issue = library.createIssue("12","ramy","4");
        Optional<Issue> issueOptional1 = issueRepository.findById(issue.getIssueId());
        assertTrue(issueOptional1.isPresent());
        System.out.println(issueOptional1.get());
    }
}