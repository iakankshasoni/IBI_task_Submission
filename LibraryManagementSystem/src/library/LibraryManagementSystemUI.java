package LibraryManagementSystem.src.library;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;


public class LibraryManagementSystemUI extends JFrame {

    private List<Book> books = new ArrayList<>();
    private List<Borrower> borrowers = new ArrayList<>();

    private JPanel contentPanel;
    private CardLayout cardLayout;

    public LibraryManagementSystemUI() {
        setTitle("📚 Library Management System");
        setSize(1100, 650);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // ===== Background Panel =====
        BackgroundPanel bgPanel = new BackgroundPanel("C:\\Users\\Akanksha\\OneDrive\\Desktop\\library-project\\LibraryManagementSystem\\resources\\image.png");
        bgPanel.setLayout(new BorderLayout());

        // ===== Header Panel =====
        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(new Color(44, 62, 80, 200));
        headerPanel.setPreferredSize(new Dimension(0, 70));

        JLabel titleLabel = new JLabel("📚 Library Dashboard");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 28));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 10));

        JLabel subtitle = new JLabel("Manage Books • Borrowers • Transactions", JLabel.RIGHT);
        subtitle.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        subtitle.setForeground(Color.LIGHT_GRAY);
        subtitle.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 20));

        headerPanel.add(titleLabel, BorderLayout.WEST);
        headerPanel.add(subtitle, BorderLayout.EAST);

        // ===== Sidebar =====
        JPanel sidebar = new JPanel();
        sidebar.setLayout(new GridLayout(7, 1, 10, 10));
        sidebar.setPreferredSize(new Dimension(220, 0));
        sidebar.setBackground(new Color(0, 0, 0, 180));

        JButton addBookBtn = createStyledButton("➕ Add Book", new Color(52, 152, 219));
        JButton viewBooksBtn = createStyledButton("📖 View Books", new Color(46, 204, 113));
        JButton borrowBookBtn = createStyledButton("📌 Borrow Book", new Color(241, 196, 15));
        JButton returnBookBtn = createStyledButton("🔄 Return Book", new Color(230, 126, 34));
        JButton searchBookBtn = createStyledButton("🔍 Search Book", new Color(231, 76, 60));
        JButton aboutBtn = createStyledButton("ℹ️ About", new Color(155, 89, 182));
        JButton exitBtn = createStyledButton("❌ Exit", new Color(149, 165, 166));

        sidebar.add(addBookBtn);
        sidebar.add(viewBooksBtn);
        sidebar.add(borrowBookBtn);
        sidebar.add(returnBookBtn);
        sidebar.add(searchBookBtn);
        sidebar.add(aboutBtn);
        sidebar.add(exitBtn);

        // ===== Content Panel (CardLayout) =====
        cardLayout = new CardLayout();
        contentPanel = new JPanel(cardLayout);
        contentPanel.setOpaque(false);
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // ===== Pages =====
        JPanel homePage = createPagePanel("🏠 Welcome to the Library Dashboard");
        JPanel addBookPage = createAddBookPage();
        JPanel viewBooksPage = createViewBooksPage();
        JPanel borrowBookPage = createBorrowBookPage();
        JPanel returnBookPage = createReturnBookPage();
        JPanel searchBookPage = createSearchBookPage();
        JPanel aboutPage = createPagePanel("📚 Library Management System\nDeveloped in Java Swing");

        contentPanel.add(homePage, "HOME");
        contentPanel.add(addBookPage, "ADD_BOOK");
        contentPanel.add(viewBooksPage, "VIEW_BOOKS");
        contentPanel.add(borrowBookPage, "BORROW_BOOK");
        contentPanel.add(returnBookPage, "RETURN_BOOK");
        contentPanel.add(searchBookPage, "SEARCH_BOOK");
        contentPanel.add(aboutPage, "ABOUT");

        // ===== Layout =====
        bgPanel.add(headerPanel, BorderLayout.NORTH);
        bgPanel.add(sidebar, BorderLayout.WEST);
        bgPanel.add(contentPanel, BorderLayout.CENTER);
        add(bgPanel);

        // ===== Button Actions =====
        addBookBtn.addActionListener(e -> cardLayout.show(contentPanel, "ADD_BOOK"));
        viewBooksBtn.addActionListener(e -> cardLayout.show(contentPanel, "VIEW_BOOKS"));
        borrowBookBtn.addActionListener(e -> cardLayout.show(contentPanel, "BORROW_BOOK"));
        returnBookBtn.addActionListener(e -> cardLayout.show(contentPanel, "RETURN_BOOK"));
        searchBookBtn.addActionListener(e -> cardLayout.show(contentPanel, "SEARCH_BOOK"));
        aboutBtn.addActionListener(e -> cardLayout.show(contentPanel, "ABOUT"));
        exitBtn.addActionListener(e -> System.exit(0));

        // ===== Preload Computer Science Books =====
      preloadCSBooks();

    }

    // ===== Utility: Styled Button =====
    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setBackground(bgColor);
        button.setForeground(Color.WHITE);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setFocusPainted(false);
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        button.setBorder(BorderFactory.createEmptyBorder(12, 20, 12, 20));
        button.setOpaque(true);
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) { button.setBackground(bgColor.darker()); }
            public void mouseExited(java.awt.event.MouseEvent evt) { button.setBackground(bgColor); }
        });
        return button;
    }

    // ===== Background Panel =====
    static class BackgroundPanel extends JPanel {
        private Image backgroundImage;
        public BackgroundPanel(String path) {
            try { backgroundImage = new ImageIcon(path).getImage(); } 
            catch (Exception e) { System.out.println("⚠️ Background image not found: " + path); }
        }
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            if (backgroundImage != null) g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }

    // ===== Create a simple page panel =====
    private JPanel createPagePanel(String text) {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        JLabel label = new JLabel("<html><div style='text-align:center;'>" + text + "</div></html>");
        label.setFont(new Font("Segoe UI", Font.BOLD, 24));
        label.setForeground(Color.WHITE);
        panel.add(label);
        return panel;
    }

    // ===== Add Book Page =====
    private JPanel createAddBookPage() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);

        JTextArea addBookArea = new JTextArea();
        addBookArea.setEditable(false);
        addBookArea.setOpaque(false);
        addBookArea.setForeground(Color.WHITE);
        addBookArea.setFont(new Font("Consolas", Font.PLAIN, 16));

        JScrollPane scroll = new JScrollPane(addBookArea);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        panel.add(scroll, BorderLayout.CENTER);

        JButton addButton = new JButton("➕ Add New Book");
        addButton.setFont(new Font("Segoe UI", Font.BOLD, 16));
        panel.add(addButton, BorderLayout.SOUTH);

        addButton.addActionListener(e -> {
            try {
                int id = books.size() + 1;
                String title = JOptionPane.showInputDialog("Enter Book Title:");
                String author = JOptionPane.showInputDialog("Enter Author Name:");
                Book b = new Book(id, title, author);
                books.add(b);
                addBookArea.append(b + "\n");
            } catch (Exception ex) { JOptionPane.showMessageDialog(this, "❌ Invalid input!"); }
        });

        return panel;
    }

    // ===== View Books Page =====
  private JPanel createViewBooksPage() {
    JPanel panel = new JPanel(new BorderLayout());
    panel.setOpaque(false);

    String[] columns = {"ID", "Title", "Author", "Available"};
    DefaultTableModel tableModel = new DefaultTableModel(columns, 0);
    JTable booksTable = new JTable(tableModel);
    booksTable.setEnabled(false); // make table read-only

    // Populate table with preloaded books initially
    for (Book b : books) {
        tableModel.addRow(new Object[]{b.getBookID(), b.getTitle(), b.getAuthor(), b.isAvailable() ? "Yes" : "No"});
    }

    JScrollPane scroll = new JScrollPane(booksTable);
    panel.add(scroll, BorderLayout.CENTER);

    JButton refreshButton = new JButton("🔄 Refresh List");
    panel.add(refreshButton, BorderLayout.SOUTH);

    refreshButton.addActionListener(e -> {
        tableModel.setRowCount(0); // clear existing rows
        for (Book b : books) {
            tableModel.addRow(new Object[]{b.getBookID(), b.getTitle(), b.getAuthor(), b.isAvailable() ? "Yes" : "No"});
        }
    });

    return panel;
}


    // ===== Borrow Book Page =====
    private JPanel createBorrowBookPage() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);

        JTextArea borrowArea = new JTextArea();
        borrowArea.setEditable(false);
        borrowArea.setOpaque(false);
        borrowArea.setForeground(Color.WHITE);
        borrowArea.setFont(new Font("Consolas", Font.PLAIN, 16));

        JScrollPane scroll = new JScrollPane(borrowArea);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        panel.add(scroll, BorderLayout.CENTER);

        JButton borrowButton = new JButton("📌 Borrow a Book");
        panel.add(borrowButton, BorderLayout.SOUTH);

        borrowButton.addActionListener(e -> {
            try {
                int borrowerID = Integer.parseInt(JOptionPane.showInputDialog("Enter Borrower ID:"));
                String name = JOptionPane.showInputDialog("Enter Borrower Name:");
                Borrower borrower = findOrCreateBorrower(borrowerID, name);

                int bookID = Integer.parseInt(JOptionPane.showInputDialog("Enter Book ID to borrow:"));
                Book book = findBookByID(bookID);

                if (book == null) JOptionPane.showMessageDialog(this, "❌ Book not found.");
                else if (!book.isAvailable()) JOptionPane.showMessageDialog(this, "⚠️ Book already borrowed.");
                else {
                    book.setAvailable(false);
                    borrower.borrowBook(book);
                    borrowArea.append("✅ " + borrower.getName() + " borrowed: " + book + "\n");
                }
            } catch (Exception ex) { JOptionPane.showMessageDialog(this, "❌ Invalid input!"); }
        });

        return panel;
    }

    // ===== Return Book Page =====
    private JPanel createReturnBookPage() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);

        JTextArea returnArea = new JTextArea();
        returnArea.setEditable(false);
        returnArea.setOpaque(false);
        returnArea.setForeground(Color.WHITE);
        returnArea.setFont(new Font("Consolas", Font.PLAIN, 16));

        JScrollPane scroll = new JScrollPane(returnArea);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        panel.add(scroll, BorderLayout.CENTER);

        JButton returnButton = new JButton("🔄 Return a Book");
        panel.add(returnButton, BorderLayout.SOUTH);

        returnButton.addActionListener(e -> {
            try {
                int borrowerID = Integer.parseInt(JOptionPane.showInputDialog("Enter Borrower ID:"));
                Borrower borrower = findBorrowerByID(borrowerID);
                if (borrower == null) { JOptionPane.showMessageDialog(this, "❌ Borrower not found."); return; }

                int bookID = Integer.parseInt(JOptionPane.showInputDialog("Enter Book ID to return:"));
                Book book = findBookByID(bookID);
                if (book == null) JOptionPane.showMessageDialog(this, "❌ Book not found.");
                else if (!borrower.getBorrowedBooks().contains(book)) JOptionPane.showMessageDialog(this, "⚠️ This borrower did not borrow this book.");
                else {
                    book.setAvailable(true);
                    borrower.returnBook(book);
                    returnArea.append("✅ " + borrower.getName() + " returned: " + book + "\n");
                }
            } catch (Exception ex) { JOptionPane.showMessageDialog(this, "❌ Invalid input!"); }
        });

        return panel;
    }

    // ===== Search Book Page =====
    private JPanel createSearchBookPage() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setOpaque(false);

        JTextArea searchArea = new JTextArea();
        searchArea.setEditable(false);
        searchArea.setOpaque(false);
        searchArea.setForeground(Color.WHITE);
        searchArea.setFont(new Font("Consolas", Font.PLAIN, 16));

        JScrollPane scroll = new JScrollPane(searchArea);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        panel.add(scroll, BorderLayout.CENTER);

        JButton searchButton = new JButton("🔍 Search Book");
        panel.add(searchButton, BorderLayout.SOUTH);

        searchButton.addActionListener(e -> {
            String keyword = JOptionPane.showInputDialog("Enter title or author:").toLowerCase();
            searchArea.setText("");
            boolean found = false;
            for (Book book : books) {
                if (book.getTitle().toLowerCase().contains(keyword) || book.getAuthor().toLowerCase().contains(keyword)) {
                    searchArea.append(book + "\n");
                    found = true;
                }
            }
            if (!found) searchArea.append("🔎 No matching books found.\n");
        });

        return panel;
    }

    // ===== Utility Methods =====
    private Book findBookByID(int bookID) {
        return books.stream().filter(b -> b.getBookID() == bookID).findFirst().orElse(null);
    }

    private Borrower findBorrowerByID(int borrowerID) {
        return borrowers.stream().filter(b -> b.getBorrowerID() == borrowerID).findFirst().orElse(null);
    }

    private Borrower findOrCreateBorrower(int borrowerID, String name) {
        Borrower borrower = findBorrowerByID(borrowerID);
        if (borrower == null) {
            borrower = new Borrower(borrowerID, name);
            borrowers.add(borrower);
        }
        return borrower;
    }

    private void preloadCSBooks() {
        books.add(new Book(1, "Introduction to Algorithms", "Cormen"));
        books.add(new Book(2, "Artificial Intelligence: A Modern Approach", "Russell"));
        books.add(new Book(3, "Clean Code", "Robert C. Martin"));
        books.add(new Book(4, "Computer Networks", "Tanenbaum"));
    }

    // ===== Main =====
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryManagementSystemUI().setVisible(true));
    }
}
