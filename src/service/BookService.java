package service;

import dao.BookDAO;
import dao.impl.BookDAOImpl;
import exceptions.BookNotAvailableException;
import model.Book;
import util.FileLogger;

import java.util.List;

public class BookService {

    private final BookDAO bookDAO = new BookDAOImpl();

    // ➕ ADD BOOK
    public void addBook(String title, String author) {

        Book book = new Book(0, title, author, true);
        bookDAO.addBook(book);

        FileLogger.log("Book added: " + title + " by " + author);
    }

    // 📚 VIEW BOOKS
    public void showBooks() {

        List<Book> books = bookDAO.getAllBooks();

        System.out.println("\n--- BOOK LIST ---");

        for (Book b : books) {
            System.out.println(
                    b.getId() + " | " +
                    b.getTitle() + " | " +
                    b.getAuthor() + " | Available: " +
                    b.isAvailable()
            );
        }

        FileLogger.log("Viewed all books");
    }

    // 📥 BORROW BOOK
    public boolean borrowBook(int id) {

        boolean success = bookDAO.borrowBook(id);

        if (success) {
            FileLogger.log("Book borrowed: ID " + id);
        } else {
            try {
                throw new BookNotAvailableException(
                        "Book not available or invalid ID: " + id
                );
            } catch (BookNotAvailableException e) {
                System.out.println(e.getMessage());
                FileLogger.log("Failed borrow attempt for book ID " + id);
            }
        }

        return success;
    }

    // 📤 RETURN BOOK
    public boolean returnBook(int id) {

        boolean success = bookDAO.returnBook(id);

        if (success) {
            FileLogger.log("Book returned: ID " + id);
        } else {
            System.out.println("Return failed.");
            FileLogger.log("Failed return attempt for book ID " + id);
        }

        return success;
    }
}