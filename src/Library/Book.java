package Library;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Objects;

public class Book {

    // Data fields
    private String id;
    private String title;
    private String author;
    private boolean isAvailable;
    private LocalDate borrowDate;
    private LocalDate dueDate;

    // Fine rate constant
    private static final double FINE_RATE = 1.1;

    // Date formatter for parsing and formatting dates as strings
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");


    // Constructor
    public Book(String id, String title, String author, boolean isAvailable) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isAvailable = isAvailable;
    }

    // Getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public LocalDate getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(LocalDate borrowDate) {
        this.borrowDate = borrowDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    // Calculate fine for overdue books
    public double calculateFine() {
        if (dueDate == null || LocalDate.now().isBefore(dueDate)) {
            return 0;
        }
        long overdueDays = ChronoUnit.DAYS.between(dueDate, LocalDate.now());
        return overdueDays * FINE_RATE;
    }

    @Override
    public String toString() {
        return id + "," + title + "," + author + "," + isAvailable + "," +
                (borrowDate != null ? borrowDate.format(DATE_FORMATTER) : "") + "," +
                (dueDate != null ? dueDate.format(DATE_FORMATTER) : "");
    }

    // Convert a comma-separated string back to a Book object
    public static Book fromString(String bookString) {
        String[] parts = bookString.split(",");

        // Basic validation
        if (parts.length != 6) {
            throw new IllegalArgumentException("Invalid book format. Expected 6 fields.");
        }

        Book book = new Book(
                parts[0].trim(),
                parts[1].trim(),
                parts[2].trim(),
                Boolean.parseBoolean(parts[3].trim())
        );

        // Parse dates if present
        if (!parts[4].trim().isEmpty()) {
            book.setBorrowDate(LocalDate.parse(parts[4].trim(), DATE_FORMATTER));
        }
        if (!parts[5].trim().isEmpty()) {
            book.setDueDate(LocalDate.parse(parts[5].trim(), DATE_FORMATTER));
        }

        return book;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        Book book = (Book) o;
        return id.equals(book.id) && title.equals(book.title) && author.equals(book.author);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, author);
    }
}
