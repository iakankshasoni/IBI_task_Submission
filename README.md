# IBI_task_Submission
:

📚 Library Management System
Overview

The Library Management System is a desktop application built using Java Swing that allows users to manage books, borrowers, and transactions in a library. The application provides a multi-page interface with navigation using a sidebar, making it simple and intuitive to use.

This mini-library system includes preloaded Computer Science books and supports all basic operations like Add Book, View Books, Borrow Book, Return Book, and Search Book.

Features

Add Book: Add new books to the library with a unique ID, title, and author.

View Books: View a table of all books with their availability status. Preloaded Computer Science books are included.

Borrow Book: Borrow a book for a borrower by entering their ID and name. Marks the book as unavailable.

Return Book: Return borrowed books and update the availability status.

Search Book: Search books by title or author.

About Page: Shows information about the project.

Navigation: Sidebar navigation allows switching between pages easily.

Preloaded Computer Science Books

The system comes with the following preloaded books:

Introduction to Algorithms – Cormen

Artificial Intelligence: A Modern Approach – Russell

Clean Code – Robert C. Martin

Computer Networks – Tanenbaum

Data Structures and Algorithms in Java – Goodrich

Operating System Concepts – Silberschatz

Database System Concepts – Korth

Installation & Setup

Ensure Java JDK 8 or higher is installed on your system.

Download the project folder.

Open the project in an IDE like Eclipse or IntelliJ IDEA.

Ensure the resources folder contains your background image (image.png). Update the path in BackgroundPanel constructor if needed.

Compile and run LibraryManagementSystemUI.java.

How to Use

Launch the application.

Use the sidebar buttons to navigate to different pages: Add Book, View Books, Borrow Book, Return Book, Search Book, or About.

Add Book: Enter book details to add a new book.

View Books: See the complete list of books and their availability.

Borrow Book: Enter borrower details and select a book ID to borrow.

Return Book: Enter borrower details and select a book ID to return.

Search Book: Enter a keyword (title or author) to search for books.

Project Structure
LibraryManagementSystem/
│
├─ src/
│   └─ library/
│       ├─ LibraryManagementSystemUI.java
│       ├─ Book.java
│       └─ Borrower.java
│
├─ resources/
│   └─ image.png
│
└─ README.md

Dependencies

Java Swing (built-in GUI framework)

No external libraries required

Screenshots

(Add screenshots of the main dashboard, View Books page, Borrow/Return pages, etc. here.)

Author

Akanksha Soni

License

This project is for educational purposes and can be freely used, modified, and shared.

I can also create a ready-to-use PDF version of this README for your project submission if you want.
