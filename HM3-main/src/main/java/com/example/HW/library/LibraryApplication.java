package com.example.HW.library;


import com.example.HW.library.components.Library;

import com.example.HW.library.model.Book;
import com.example.HW.library.model.Issue;
import com.example.HW.library.repository.BookRepository;
import com.example.HW.library.repository.IssueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

@SpringBootApplication
public class LibraryApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}


	@Autowired
	Library library;
	@Autowired
	BookRepository bookRepository;
	@Autowired
	IssueRepository issueRepository;

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);

		int choice;
		do {
			System.out.println("Menu:");
			System.out.println("1. Add a book");
			System.out.println("2. Search book by title");
			System.out.println("3. Search book by category");
			System.out.println("4. Search book by Author");
			System.out.println("5. List all books along with author");
			System.out.println("6. Issue book to student");
			System.out.println("7. List books by usn");
			System.out.println("8. Exit");
			while (true) {
				System.out.print("Enter your choice: ");
				if (scanner.hasNextInt()) {
					choice = scanner.nextInt();
					break;
				} else {
					System.out.println("That's not a valid input. Please enter a number.");
					scanner.next(); // Clear the invalid input
				}
			}
			scanner.nextLine(); // Consume the newline character

			switch (choice) {
				case 1:

					System.out.println("Add a book");
					System.out.print("Enter book title: ");
					String title = scanner.nextLine();
					System.out.print("Enter book category: ");
					String category = scanner.nextLine();
					System.out.print("Enter author name: ");
					String authorName = scanner.nextLine();
					System.out.print("Enter author email: ");
					String authorEmail = scanner.nextLine();
					while (!authorEmail.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$")){
						System.out.println("\nInvalid email ! Try again");
						System.out.print("Enter author email: ");
						authorEmail = scanner.next();
						scanner.nextLine(); // Consume the newline character
					}
					String isbn;
					while (true) {
						System.out.print("Enter book ISBN: ");
						String test = scanner.nextLine();
						Optional<Book> bookOptional = bookRepository.findById(test);
						if (bookOptional.isEmpty()) {
							isbn = test;
							break;
						} else {
							System.out.println("\nThis book already exist. please try again");
//							scanner.next(); // Clear the invalid input
						}
					}
					int quantity;
					while (true) {
						System.out.print("Enter quantity of books: ");
						if (scanner.hasNextInt()) {
							quantity = scanner.nextInt();
							break;
						} else {
							System.out.println("\nThat's not a valid number. Try again.");
							scanner.next(); // Clear the invalid input
						}
					}
					scanner.nextLine(); // Consume the newline character

					Book book = new Book(isbn,title,category,quantity);
					library.createBookAndAuthor(authorName,authorEmail,book);
					System.out.println("\nBook added successfully.");
					break;

				case 2:

					System.out.print("Enter book title: ");
					String title1 = scanner.nextLine();
					while (!title1.matches("[A-Za-z\\s]+") || title1.length() < 2) {
						System.out.println("Please enter valid title");
						System.out.println("Enter book title: ");
						title1 = scanner.next();
					}
					Optional<Book> bookOptional = bookRepository.findBookByTitle(title1);
					if (bookOptional.isPresent()) {
						System.out.print("\nBook Title: " + bookOptional.get().getTitle());
						System.out.print("\nBook Author: " + bookOptional.get().getAuthor().getName());
						System.out.print("\nBook Category: " + bookOptional.get().getCategory());
						System.out.print("\nBook Quantity: " + bookOptional.get().getQuantity());
						System.out.println("\nBook ISBN: " + bookOptional.get().getBookISBN());
					} else {
						System.out.println("Book not found.");
					}
					break;

				case 3:

					System.out.print("Enter book category: ");
					String category1 = scanner.nextLine();

					List<Book> books = bookRepository.findBooksByCategory(category1);
					if (books.isEmpty()) {
						System.out.println("\nNo books found with the specified category.");
					} else {
						for (Book book2 : books) {
							System.out.print("\nBook Title: " + book2.getTitle());
							System.out.print("\nBook Author: " + book2.getAuthor().getName());
							System.out.print("\nBook ISBN: " + book2.getBookISBN());
							System.out.print("\nBook Category: " + book2.getCategory());
							System.out.print("\nBook Quantity: " + book2.getQuantity());
							System.out.println("\n--------------------");
						}
					}
					break;

				case 4:

					System.out.print("Enter author name: ");
					String name = scanner.nextLine();
					List<Book> BookList = bookRepository.findAllWhereNameParams(name);
					if (BookList.isEmpty()) {
						System.out.println("No books found.");
					} else {
						for (Book book1 : BookList) {
							System.out.print("\nBook Title: " + book1.getTitle());
							System.out.print("\nBook ISBN: " + book1.getBookISBN());
							System.out.print("\nBook Category: " + book1.getCategory());
							System.out.print("\nBook Quantity: " + book1.getQuantity());
							System.out.println("\n--------------------");
						}
					}

					break;

				case 5:
					System.out.print("\nList all books along with author: ");
					List<Book> allBooks = bookRepository.findAll();
					if (allBooks.isEmpty()) {
						System.out.println("No books found.");
					} else {
						for (Book book1 : allBooks) {
							System.out.print("\nBook Title: " + book1.getTitle());
							System.out.print("\nBook ISBN: " + book1.getBookISBN());
							System.out.print("\nBook Category: " + book1.getCategory());
							System.out.print("\nBook Quantity: " + book1.getQuantity());
							System.out.print("\nAuthor Name: " + book1.getAuthor().getName());
							System.out.print("\nAuthor Email: " + book1.getAuthor().getEmail());
							System.out.println("\n--------------------");
						}
					}

					break;

				case 6:
					System.out.print("Enter USN: ");
					String usn = scanner.next();
					System.out.print("Enter student name: ");
					String studentName = scanner.next();
					String isbn1;
					while (true) {
						System.out.print("Enter book ISBN: ");
						String test1 = scanner.next();
						Optional<Book> bookOptionalTest = bookRepository.findById(test1);
						if (bookOptionalTest.isPresent()) {
								isbn1 = test1;
								break;
						} else {
							System.out.println("\nThis book is not exist in the library. please try another book");
//							scanner.next(); // Clear the invalid input
						}
					}

					Issue issue = library.createIssue(usn,studentName,isbn1);
					Optional<Book> bookOptional1 = bookRepository.findById(isbn1);
					System.out.println("\nBook "+bookOptional1.get().getTitle()+" issued. Return date : "+ issue.getReturnDate());
					break;

				case 7:

					System.out.print("Enter USN: ");
					String usn1;
					boolean isValidInput = false;

					do {
						usn1 = scanner.next();

						if (usn1.matches("\\d+")) {
							isValidInput = true;
						} else {
							System.out.println("Invalid input. Please enter a valid USN.\n");
							System.out.print("Enter USN: ");
						}
					} while (!isValidInput);

					List<Issue> issueList = issueRepository.findByStudentsUsn(usn1);
					if (issueList.isEmpty()) {
						System.out.println("No student found with the specified USN.\n");
					} else {
						for (Issue issue3 : issueList) {
							System.out.print("\nBook Title: " + issue3.getIssueBook().getTitle());
							System.out.print("\nStudent Name: " + issue3.getIssueStudent().getName());
							System.out.print("\nReturn date: " + issue3.getReturnDate());
							System.out.print("\n--------------------");
						}
					}

					break;

				case 8:
					// Exit the application
					System.out.println("Exiting the application...");
					System.exit(0);
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
			System.out.println(); // Add a newline for readability
		} while (choice != 8);

		scanner.close();

	}
}




