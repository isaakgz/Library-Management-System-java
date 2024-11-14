package Library;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Library {

    /*
    we use the Library class to manage the books and users in the library.
    * */


    //lists to hold books and users
    private List<Book> books;   //implemented by ArrayList
    private List<User> users;  //implemented by ArrayList


    //a constructor that initializes the books and users lists
    public Library() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }


    //a method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully.");
    }

    //a method to remove a book from the library
    public void removeBook(Book book) {
        books.remove(book);
        System.out.println("Book removed successfully.");
    }

    //a method to find book by id
    public Book findBookById(String bookId) {
        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                return book;
            }
        }
        return null;
    }

    //a method to display all books in the library
    public void displayBooks() {
        for (Book book : books) {
            System.out.println(book);
        }
    }

    //a method to add a user to the library
    public void addUser(User user) {
        users.add(user);
        System.out.println("User added successfully.");
    }

    //a method to remove a user from the library
    public void removeUser(User user) {
        users.remove(user);
        System.out.println("User removed successfully.");
    }

    //a method to find user by id
    public User findUserById(String userId) {
        for (User user : users) {
            if (user.getUserId().equals(userId)) {
                return user;
            }
        }
        return null;
    }


    //a method to borrow a book
   public void borrowBook(String bookId, String userId) {

        //find the user and book
        User user = findUserById(userId);
        Book book = findBookById(bookId);

        //check if user and book exist
      if (user == null) {
          System.out.println("User not found with this id.");
          return;
      } else if (book == null) {
            System.out.println("Book not found with this id.");
            return;
      } else if (!book.isAvailable()) {
          System.out.println("Book is not available for borrowing.");
            return;
      } else {
            //borrow the book
          book.setAvailable(false);
          book.setBorrowDate(LocalDate.now());
          book.setDueDate(LocalDate.now().plusDays(7)); //assume 7 days borrowing period
          System.out.println("Book borrowed successfully.");
      }


   }

   public void returnBook(String bookId, String userId) {
        Book book = findBookById(bookId);
        User user = findUserById(userId);

        if (user == null) {
            System.out.println("User not found with this id.");
            return;
        } else if (book == null || !book.isAvailable()) {
            System.out.println("book not found or already returned");
            return;
        }  else {

            //check for overdue books
            double fine = book.calculateFine();
            if (fine > 0) {
                System.out.println("Fine for overdue book: ETB" + fine);
            }

            //reset book status
            book.setAvailable(true);
            book.setBorrowDate(null);
            book.setDueDate(null);
            System.out.println("Book returned successfully.");
            return;

        }

   }

   // a method to save books to the file books.txt
   public void saveBooksToFile() throws IOException {
       File file = new File("books.txt");

       if (!file.exists() && !file.createNewFile()) {
           System.out.println("Error: Could not create the file.");
           return;
       }

       try (PrintWriter output = new PrintWriter(file)) {
           for (Book book : books) {
               output.println(book.toString());
           }
           System.out.println("Books saved to " + file.getName());
       } catch (IOException e) {
           System.out.println("Error saving to file: " + e.getMessage());
           throw e;  // rethrow to allow further handling if needed
       }
   }

   // a method to read books from the file
    public void loadBooksFromFile() throws Exception {
        File file = new File("books.txt");

        Scanner input = new Scanner(file);

        while (input.hasNext()) {
            String id = input.nextLine();
            String title = input.nextLine();
            String author = input.nextLine();
            boolean isAvailable = Boolean.parseBoolean(input.nextLine());
            String borrowDate = input.nextLine();
            String dueDate = input.nextLine();
            System.out.println("Book loaded: " + id + ", " + title + ", " + author + ", " + isAvailable + ", " + borrowDate + ", " + dueDate);
        }
        input.close();
    }

    // a method to save users to the file users.txt
    public void saveUsersToFile()  throws IOException {

        //create a file object
        File file = new File("users.txt");

        //check if the file exists, if not create a new file
        if (file.exists() && !file.createNewFile()) {
            System.out.println("Error: Could not create the file.");
            return;
        }

        //write the users to the file
        try(PrintWriter output = new PrintWriter(file)) {

            //loop through the users list
            for (User user : users) {
                output.println(user.toString());
            }

            //print a success message
            System.out.println("Users saved to " + file.getName());

        } catch (IOException e) {
            //print an error message
            System.out.println("Error saving to file: " + e.getMessage());
            //rethrow the exception to allow further handling if needed
            throw e;
        }
    }

    // a method to load users from the file
    public void loadUsersFromFile() throws Exception {

        //create file object
        File file = new File("users.txt");

        //create a scanner object
        Scanner input = new Scanner(file);

        //loop through the file
        while (input.hasNext()) {
            //read user details from the file

            String name = input.nextLine();
            String userId = input.nextLine();
            String password = input.nextLine();
            String role = input.nextLine();
            System.out.println("User loaded: " + userId + ", " + name + ", " + ", " + role);
        }
      
    }

}

