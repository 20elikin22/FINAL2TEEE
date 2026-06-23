package dao;

import model.Book;
import java.util.List;

public interface BookDAO {

    void addBook(Book book);

    List<Book> getAllBooks();

    boolean borrowBook(int bookId);

    boolean returnBook(int bookId);
}