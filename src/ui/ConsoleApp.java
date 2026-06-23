package ui;

import java.util.Scanner;

import model.Student;
import model.User;
import service.AuthService;
import service.BookService;
import enums.UserRole;

public class ConsoleApp {

    private final Scanner scanner = new Scanner(System.in);
    private final AuthService authService = new AuthService();
    private final BookService bookService = new BookService();

    public void start() {

        while (true) {

            System.out.println("\n=== SMART LIBRARY HUB ===");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // FIX: consume newline

            switch (choice) {

                case 1:
                    register();
                    break;

                case 2:
                    login();
                    break;

                case 3:
                    System.out.println("Goodbye!");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void register() {

        System.out.println("\n--- REGISTER ---");

        System.out.print("Name: ");
        String name = scanner.nextLine();

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = new Student(
                0,
                name,
                username,
                password
        );

        boolean success = authService.register(user);

        if (success) {
            System.out.println("Registration successful!");
        } else {
            System.out.println("Registration failed!");
        }
    }

    private void login() {

        System.out.println("\n--- LOGIN ---");

        System.out.print("Username: ");
        String username = scanner.nextLine();

        System.out.print("Password: ");
        String password = scanner.nextLine();

        User user = authService.login(username, password);

        if (user != null) {

            System.out.println("\nWelcome " + user.getName());
            System.out.println("Role: " + user.getRole());

            if (user.getRole() == UserRole.STUDENT) {
                studentMenu(user);
            } else {
                librarianMenu(user);
            }

        } else {
            System.out.println("Invalid credentials!");
        }
    }

    private void studentMenu(User user) {

        while (true) {

            System.out.println("\n--- STUDENT MENU ---");
            System.out.println("1. View Books");
            System.out.println("2. Borrow Book");
            System.out.println("3. Return Book");
            System.out.println("4. Logout");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // FIX

            switch (choice) {

                case 1:
                    bookService.showBooks();
                    break;

                case 2:
                    System.out.print("Enter Book ID: ");
                    int borrowId = scanner.nextInt();
                    scanner.nextLine(); // FIX

                    if (bookService.borrowBook(borrowId)) {
                        System.out.println("Book borrowed successfully!");
                    } else {
                        System.out.println("Book not available or invalid ID.");
                    }
                    break;

                case 3:
                    System.out.print("Enter Book ID: ");
                    int returnId = scanner.nextInt();
                    scanner.nextLine(); // FIX

                    if (bookService.returnBook(returnId)) {
                        System.out.println("Book returned successfully!");
                    } else {
                        System.out.println("Return failed.");
                    }
                    break;

                case 4:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private void librarianMenu(User user) {

        while (true) {

            System.out.println("\n--- LIBRARIAN MENU ---");
            System.out.println("1. View Books");
            System.out.println("2. Add Book");
            System.out.println("3. Logout");
            System.out.print("Choose: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // FIX

            switch (choice) {

                case 1:
                    bookService.showBooks();
                    break;

                case 2:
                    System.out.print("Enter title: ");
                    String title = scanner.nextLine();

                    System.out.print("Enter author: ");
                    String author = scanner.nextLine();

                    bookService.addBook(title, author);

                    System.out.println("Book added!");
                    break;

                case 3:
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}