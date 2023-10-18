package com.example.HW.library;


import com.example.HW.library.components.Library;

//import com.example.HW.library.components.Library;
import com.example.HW.library.model.Author;
import com.example.HW.library.model.Book;
import com.example.HW.library.model.Student;
import com.example.HW.library.repository.AuthorRepository;
import com.example.HW.library.repository.BookRepository;
import com.example.HW.library.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

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
	StudentRepository studentRepository;
	@Autowired
	AuthorRepository authorRepository;

	@Override
	public void run(String... args) throws Exception {              ///Main
		System.out.println("hello");
//
//		Book book = new Book("356712","Alonso Flores", "cardiology", 5);
//		bookRepository.save(book);
//
//		System.out.println(library.findBookByTitle("Alonso Flores"));
//		Optional<Book> bookOptional = bookRepository.findBookByTitle("Alonso Flores");
//		System.out.println(bookOptional.get());
//
//		Optional<Book> book2Optional = bookRepository.findBookByBookISBN("356712");
//		System.out.println(book2Optional.get());




		Scanner scanner = new Scanner(System.in);
		Library library = new Library();

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
			System.out.print("Enter your choice: \n");
			choice = scanner.nextInt();
			scanner.nextLine(); // Consume the newline character

			switch (choice) {
				case 1:

					System.out.println("Add a book");

					System.out.println("Enter book title: ");
					String title = scanner.nextLine();

					System.out.println("Enter book category: ");
					String category = scanner.nextLine();

					System.out.println("Enter author name: ");
					String author = scanner.nextLine();

					System.out.println("Enter book ISBN: ");
					String isbn = scanner.nextLine();

					System.out.println("Enter quantity of books: ");
					int quantity = scanner.nextInt();
					scanner.nextLine(); // Consume the newline character

					Book book = new Book(isbn, title, category, quantity);
					bookRepository.save(book);

					System.out.println("Book added successfully.");
					break;


				case 2:

					System.out.println("Enter book title: ");
					String title1 = scanner.nextLine();
					Optional<Book> bookOptional = bookRepository.findBookByTitle(title1);
					if (bookOptional.isPresent()) {
						System.out.println(bookOptional.get());
					} else {
						System.out.println("Book not found.");
					}
					break;
				case 3:

					System.out.println("Enter book category: ");
					String category1 = scanner.nextLine();

					List<Book> books = bookRepository.findBooksByCategory(category1);
					if (books.isEmpty()) {
						System.out.println("No books found with the specified category.");
					} else {
						for (Book book2 : books) {
							System.out.println("Title: " + book2.getTitle());
							//System.out.println("Author: " + book2.getAuthor().getName());
							System.out.println("ISBN: " + book2.getBookISBN());
							System.out.println("Category: " + book2.getCategory());
							System.out.println("Quantity: " + book2.getQuantity());
							System.out.println("--------------------");
						}
					}
					break;


				case 4:


					break;


				case 5:
					System.out.println("List all books along with author:");
					List<Book> allBooks = bookRepository.findAll();
					if (allBooks.isEmpty()) {
						System.out.println("No books found.");
					} else {
						for (Book book1 : allBooks) {
							System.out.println("Title: " + book1.getTitle());
							//System.out.println("Author: " + book1.getAuthor().getName());
							System.out.println("ISBN: " + book1.getBookISBN());
							System.out.println("Category: " + book1.getCategory());
							System.out.println("Quantity: " + book1.getQuantity());
							System.out.println("--------------------");
						}
					}

					break;

				case 6:
					// Issue book to student
					// Implement the logic to issue a book to a student
					break;
				case 7:

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




