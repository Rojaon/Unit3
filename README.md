# IronLibrary
<a name="readme-top"></a>
<!-- TABLE OF CONTENTS -->
<details>
  <summary>Table of Contents</summary>
  <ol>
    <li><a href="#about-the-project">About The Project</a></li>
    <li><a href="#built-with">Built With</a></li>
    <li><a href="#getting-started">Getting Started</a>
    <li><a href="#prerequisites">Prerequisites</a></li>
    <li><a href="#actions">Actions</a></li>
    <li><a href="#demo">Demo</a></li>
    <li><a href="#team-members">Team members</a></li>

</ol>
</details>


<!-- ABOUT THE PROJECT -->
## About The Project
This is a JAVA application that implement a Library Management System allows users to manage and acquire data about books used by students. It is include four main classes: Author, Book, Student, and Issue.
The application has a menu with options and users can input their choices then the system will execute the corresponding actions, such as adding a book with its author details or searching for a book based on certain criteria, etc. The menu will be automatically displayed after each action, till the user enter number 8 as a choice, so it will Exiting the application.
The code handle exceptions gracefully and store all data in a normalized SQL database.
Unit tests have been created for methods.


<p align="right">(<a href="#readme-top">back to top</a>)</p>

# Built With
* [![Java language][Java]][Java-url]


<p align="right">(<a href="#readme-top">back to top</a>)</p>



# Prerequisites
Before you can run the IronLibrary, you need to ensure that you have the following software installed:

- [IntelliJ IDEA](https://www.jetbrains.com/idea/): A powerful integrated development environment (IDE) for Java development.
- [Java Development Kit (JDK)](https://www.oracle.com/java/technologies/javase-downloads.html): Java development tools and libraries.




# Classes
The application consists of the following main classes:

- Book: Represents a BOOK with properties such as isbn, title, category and a quantity.
- Author: Represents an AUTHOR with properties such as name, email and authorBook.
- Issue: Represents an ISSUE with properties such as issueDate, returnDate, issueStudent and issueBook.
- Student: Represents a STUDENT with properties such as usn and name
- LibraryApplication: The main class that manages the Library system, including switch case structure, menu of options, and executing some of commands.


# Actions
The application supports the following Actions:

- Add a book [CHOICE 1]: Responsible for adding a book and its author in the system.
- Search book by title [CHOICE 2]: Responsible for searching a book by title.
- Search book by category [CHOICE 3]: Responsible for searching a book by category.
- Search book by author [CHOICE 4]: Responsible for searching a book by author name.
- List all books along with author [CHOICE 5]: Responsible for listing all the books available and there corresponding authors.
- Issue book to student [CHOICE 6]: Responsible for creating a student and issuing him/her the specified book. The date issued represent the current date and the return date should be after 7 days.
- List books by usn [CHOICE 7]: Responsible for listing all books rented by the specified student.
- exit [CHOICE 8]: Responsible for exiting the application.

# Demo
To see a demo of the project, you can download the PDF file from [here]().


<p align="right">(<a href="#readme-top">back to top</a>)</p>


<!-- Team members -->
## Team members
- [Arijj](https://github.com/Rojaon)
- [Jawaher](https://github.com/jawahermut)
- [Jehan](https://github.com/JehanYahya)
- [Mona](https://github.com/MonaHAx)
- [Sara](https://github.com/saraturki12)
  

<p align="right">(<a href="#readme-top">back to top</a>)</p>

[Java]: https://img.shields.io/badge/java-000000?style=for-the-badge&logo=java
[Java-url]: https://www.java.com/en/
