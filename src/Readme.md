# Library Management System (CLI)

This is a **Command Line Interface (CLI)** based **Library Management System (LMS)** implemented in **Java**. The system supports **Admin** and **Member** roles, tracks overdue books and fines, sorts books by author, title, and ID, and stores data in a file for persistence.

## Table of Contents
1. [System Overview](#system-overview)
2. [Features](#features)
3. [Technologies Used](#technologies-used)
4. [Classes & Structure](#classes-structure)
5. [Features Implementation](#features-implementation)
6. [User Roles and Authentication](#user-roles-and-authentication)
7. [Persistence](#persistence)
8. [Tracking Overdue Books and Fines](#tracking-overdue-books-and-fines)
9. [Sorting Books](#sorting-books)


---

## System Overview

This **Library Management System** is a simple **CLI-based Java application** that enables users to manage books, handle different user roles (Admin and Member), track overdue books, and calculate fines. It also allows users to sort books by different attributes (author, title, and ID).

---

## Features

- **User Roles**: Admin and Member roles with respective functionalities.
- **Login Functionality**: Admin and Member can log in with their credentials.
- **Book Management**:
    - Admin can add new books and display all books in the library.
    - Members can borrow and return books, as well as view available books.
- **Overdue Book Tracking**: Calculates fines for overdue books.
- **Book Sorting**: Books can be sorted by author, title, or ID.

---

## Technologies Used

- **Java**: Core programming language.
- **File-based Storage**: Persistence is handled via file I/O Implement File-Based Persistence with a TXT File: for storing book data.
- **CLI Interface**: Command line interface for user interaction.

---

## Classes & Structure

- **LibraryManagementSystem**: Main class that runs the program. Handles user login and menu navigation based on roles.
- **User**: Represents a user (either Admin or Member). Stores username, password, and role.
- **Library**: Stores a list of books and provides methods to add, display, borrow, and return books. Manages file-based persistence.
- **Book**: Represents a book with an ID, title, author, availability status, borrow date, and due date. Calculates fines for overdue books.
- **BookComparator**: Utility class for sorting books by different attributes (author, title, ID).

---

## Features Implementation

### User Roles and Authentication
- Users are pre-defined with username, password, and role (Admin or Member).
- Login checks credentials and displays appropriate menu options based on role.

### Persistence
-Implement File-Based Persistence with a TXT File: Books are loaded from the file on startup, and updates are saved back to the file.

### Overdue Book Tracking and Fines
- Fines are calculated based on overdue days. If a book is overdue, a fine is charged at a rate of **1 per day**.

### Sorting Books
- Books can be sorted by:
    - **Title**
    - **Author**
    - **Book ID**

---

## User Roles and Authentication

- **Admin**:
    - Username: `admin`
    - Password: `admin123`
    - Can add new books and display all books.

- **Member**:
    - Username: `member`
    - Password: `member123`
    - Can borrow, return books, and view available books.

---

## Persistence
Implement File-Based Persistence with a TXT File


## Admin view
Welcome to the Library Management System
Username: admin
Password: admin123
Login successful. Welcome, admin!

Admin Menu:
1. Add Book
2. Display All Books
3. Logout
   Enter your choice: 1

## member view
Welcome to the Library Management System
Username: member
Password: member123
Login successful. Welcome, member!

Member Menu:
1. Borrow Book
2. Return Book
3. Display All Books
4. Logout
   Enter your choice: 3
