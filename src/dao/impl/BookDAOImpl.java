package dao.impl;

import dao.BookDAO;
import model.Book;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BookDAOImpl implements BookDAO {

    @Override
    public void addBook(Book book) {

        String sql = "INSERT INTO books(title, author, available) VALUES (?, ?, ?)";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, book.getTitle());
            stmt.setString(2, book.getAuthor());
            stmt.setBoolean(3, true);

            stmt.executeUpdate();

            System.out.println("Book added successfully!");

        } catch (Exception e) {
            System.out.println("Add book error: " + e.getMessage());
        }
    }

    @Override
    public List<Book> getAllBooks() {

        List<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM books";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {

                books.add(new Book(
                        rs.getInt("id"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getBoolean("available")
                ));
            }

        } catch (Exception e) {
            System.out.println("Fetch books error: " + e.getMessage());
        }

        return books;
    }

    @Override
    public boolean borrowBook(int bookId) {

        String sql = "UPDATE books SET available = FALSE WHERE id = ? AND available = TRUE";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, bookId);

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Borrow error: " + e.getMessage());
            return false;
        }
    }

    @Override
    public boolean returnBook(int bookId) {

        String sql = "UPDATE books SET available = TRUE WHERE id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, bookId);

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println("Return error: " + e.getMessage());
            return false;
        }
    }
}