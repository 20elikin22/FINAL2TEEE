package service;

import dao.BookDAO;
import dao.impl.BookDAOImpl;
import model.Book;

import java.util.List;

public class LibraryService {

    private final BookDAO bookDAO = new BookDAOImpl();

    // Show all books
    public void showBooks() {

        List<Book> books = bookDAO.getAllBooks();

        System.out.println("\n--- BOOK LIST ---");

        if (books.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book b : books) {
            System.out.println(
                    b.getId() + " | " +
                    b.getTitle() + " | " +
                    b.getAuthor() + " | Available: " +
                    b.isAvailable()
            );
        }
    }

    // Borrow book
    public boolean borrowBook(int bookId) {
        return bookDAO.borrowBook(bookId);
    }

    // Return book
    public boolean returnBook(int bookId) {
        return bookDAO.returnBook(bookId);
    }

    // Add book
    public void addBook(String title, String author) {
        bookDAO.addBook(new Book(0, title, author, true));
    }
}