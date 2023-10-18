package com.example.HW.library;


import com.example.HW.library.components.Library;

import com.example.HW.library.model.Book;
import com.example.HW.library.model.Issue;
import com.example.HW.library.model.Student;
import com.example.HW.library.repository.AuthorRepository;
import com.example.HW.library.repository.BookRepository;
import com.example.HW.library.repository.IssueRepository;
import com.example.HW.library.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
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
	StudentRepository studentRepository;
	@Autowired
	IssueRepository issueRepository;
	@Autowired
	AuthorRepository authorRepository;

	@Override
	public void run(String... args) throws Exception {              ///Main

		Scanner scanner = new Scanner(System.in);
//		Library library = new Library();

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
					String authorName = scanner.nextLine();

					System.out.println("Enter author email: ");
					String authorEmail = scanner.nextLine();

					System.out.println("Enter book ISBN: ");
					String isbn = scanner.nextLine();

					System.out.println("Enter quantity of books: ");
					int quantity = scanner.nextInt();
					scanner.nextLine(); // Consume the newline character

					Book book = new Book(isbn,title,category,quantity);
					library.createBookAndAuthor(authorName,authorEmail,book);

					System.out.println("Book added successfully.");
					break;


				case 2:

					System.out.println("Enter book title: ");
					String title1 = scanner.nextLine();
					Optional<Book> bookOptional = bookRepository.findBookByTitle(title1);
					if (bookOptional.isPresent()) {
						System.out.println("Book Title: "+bookOptional.get().getTitle());
						System.out.println("Book Author: "+bookOptional.get().getAuthor().getName());
						System.out.println("Book Category: "+bookOptional.get().getCategory());
						System.out.println("Book Quantity: "+bookOptional.get().getQuantity());
						System.out.println("Book ISBN: "+bookOptional.get().getBookISBN());
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
							System.out.println("Book Title: " + book2.getTitle());
							System.out.println("Book Author: " + book2.getAuthor().getName());
							System.out.println("Book ISBN: " + book2.getBookISBN());
							System.out.println("Book Category: " + book2.getCategory());
							System.out.println("Book Quantity: " + book2.getQuantity());
							System.out.println("--------------------");
						}
					}
					break;


				case 4:

					System.out.println("Enter author name: ");
					String name = scanner.nextLine();
					List<Book> BookList = bookRepository.findAllWhereNameParams(name);
					if (BookList.isEmpty()) {
						System.out.println("No books found.");
					} else {
						for (Book book1 : BookList) {
							System.out.println("Book Title: " + book1.getTitle());
							System.out.println("Book ISBN: " + book1.getBookISBN());
							System.out.println("Book Category: " + book1.getCategory());
							System.out.println("Book Quantity: " + book1.getQuantity());
							System.out.println("--------------------");
						}
					}

					break;


				case 5:
					System.out.println("List all books along with author:");
					List<Book> allBooks = bookRepository.findAll();
					if (allBooks.isEmpty()) {
						System.out.println("No books found.");
					} else {
						for (Book book1 : allBooks) {
							System.out.println("Book Title: " + book1.getTitle());
							System.out.println("Book ISBN: " + book1.getBookISBN());
							System.out.println("Book Category: " + book1.getCategory());
							System.out.println("Book Quantity: " + book1.getQuantity());
							System.out.println("Author Name: " + book1.getAuthor().getName());
							System.out.println("Author Email: " + book1.getAuthor().getEmail());
							System.out.println("--------------------");
						}
					}

					break;

				case 6:
					System.out.print("Enter USN: ");
					String usn = scanner.next();
					System.out.print("Enter student name: ");
					String studentName = scanner.next();
					System.out.print("Enter book ISBN: ");
					isbn = scanner.next();

					DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
					Date date = new Date();
					String today = dateFormat.format(date);
					Calendar cal = Calendar.getInstance();
					cal.add(Calendar.DATE, 7);
					Date date2 = cal.getTime();
					String returnDate = dateFormat.format(date2);

					Optional<Book> bookOptional1 = bookRepository.findById(isbn);
					Student student = new Student(usn , studentName);
					studentRepository.save(student);
					Issue issue = new Issue(today, returnDate , student , bookOptional1.get());
					issueRepository.save(issue);
					System.out.println("Book "+bookOptional1.get().getTitle()+" issued. Return date : "+ returnDate);
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




