package Library;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws Exception {
        // Create a new library
        Library library = new Library();

        // Create a new book
        Book book1 = new Book("1", "Java Programming", "John Doe", true);
        Book book2 = new Book("2", "Python Programming", "Jane Doe", true);

        // Add the book to the library
        library.addBook(book1);
        library.addBook(book2);

        // Display all books in the library
        library.displayBooks();

        // Create a new user
        User user1 = new User("Alice", "1", "password", "Member");
        User user2 = new User("Bob", "2", "password", "Admin");

        // Add the user to the library
        library.addUser(user1);
        library.addUser(user2);

        library.saveBooksToFile();
        library.loadBooksFromFile();
    }
}
