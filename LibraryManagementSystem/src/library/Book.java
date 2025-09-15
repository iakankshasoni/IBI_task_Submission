package LibraryManagementSystem.src.library;
// package library;

public class Book {
    private int bookID;
    private String title;
    private String author;
    private boolean available;

    public Book(int bookID, String title, String author) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.available = true;
    }

    public int getBookID() { return bookID; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public boolean isAvailable() { return available; }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return bookID + " | " + title + " | " + author + " | " + (available ? "Available" : "Borrowed");
    }
}
