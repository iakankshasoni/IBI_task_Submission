package LibraryManagementSystem.src.library;
// package library;

import java.util.ArrayList;
import java.util.List;

public class Borrower {
    private int borrowerID;
    private String name;
    private List<Book> borrowedBooks;

    public Borrower(int borrowerID, String name) {
        this.borrowerID = borrowerID;
        this.name = name;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getBorrowerID() { return borrowerID; }
    public String getName() { return name; }
    public List<Book> getBorrowedBooks() { return borrowedBooks; }

    public void borrowBook(Book book) {
        borrowedBooks.add(book);
    }

    public void returnBook(Book book) {
        borrowedBooks.remove(book);
    }
}
