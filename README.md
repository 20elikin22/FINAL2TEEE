# 📚 Smart Library Hub (SLH)

## 🧠 Project Overview

Smart Library Hub is a Java-based console application that manages library operations using a layered architecture. It integrates Object-Oriented Programming principles, JDBC database connectivity, file handling, and exception management.

The system supports role-based access for Students and Librarians, allowing secure and structured interaction with library resources.

---

## 🏗️ Architecture

The system follows a **Layered Architecture Design**:

```
UI Layer (ConsoleApp)
        ↓
Service Layer (Business Logic)
        ↓
DAO Layer (Database Access)
        ↓
MySQL Database
```

This ensures separation of concerns, maintainability, and scalability.

---

## ⚙️ Features

### 👤 Authentication

* User registration
* Secure login system
* Role-based access control (Student / Librarian)

### 📚 Book Management

* Add books (Librarian only)
* View all books
* Borrow books
* Return books
* Availability tracking

### 📋 Loan System

* Tracks borrowing history
* Stores timestamps of borrowing actions

### ⚠️ Exception Handling

* Custom exceptions for invalid operations
* Graceful error messages

### 🧾 File Handling

* Activity logging (`activity.log`)
* System reports (`report.txt`)

---

## 🧠 OOP Concepts Implemented

* Classes & Objects
* Encapsulation
* Inheritance
* Polymorphism (dynamic method dispatch)
* Abstraction (interfaces & abstract classes)
* `super`, `this`, `final`
* Interfaces (DAO pattern)

---

## 🗄️ Database Schema

### Users Table

* id
* name
* username
* password
* role

### Books Table

* id
* title
* author
* available

### Loans Table

* id
* user_id
* book_id
* borrow_date
* return_date
* status

---

## 🧰 Technologies Used

* Java (JDK 17)
* JDBC
* MySQL
* VS Code
* Console-based UI

---

## 🚀 How to Run

1. Start MySQL server
2. Create database `smart_library`
3. Run schema from `/database/schema.sql`
4. Add MySQL Connector JAR to `/lib`
5. Run `Main.java`

---

## 👥 Team Contribution

> (Solo Implementation)

* Full-stack design and development
* Database integration
* Business logic implementation
* UI development
* Testing and debugging

---

## 📌 Future Improvements

* JavaFX GUI version
* Password encryption (security upgrade)
* Advanced reporting dashboard
* Search & filter system
