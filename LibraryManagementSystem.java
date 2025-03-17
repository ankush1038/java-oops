// Abstract class: LibraryItem
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
    }

    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }

    public abstract int getLoanDuration();
}

// Interface: Reservable
interface Reservable {
    void reserveItem();
    boolean checkAvailability();
}

// Subclass: Book
class Book extends LibraryItem implements Reservable {
    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14; // 14 days loan period
    }

    @Override
    public void reserveItem() {
        System.out.println("Book reserved: " + getTitle());
    }

    @Override
    public boolean checkAvailability() {
        return true; // Example: always available
    }
}

// Subclass: Magazine
class Magazine extends LibraryItem {
    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7; // 7 days loan period
    }
}

// Subclass: DVD
class DVD extends LibraryItem implements Reservable {
    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 5; // 5 days loan period
    }

    @Override
    public void reserveItem() {
        System.out.println("DVD reserved: " + getTitle());
    }

    @Override
    public boolean checkAvailability() {
        return false; // Example: not available
    }
}

// Main class to test Library Management System
public class LibraryManagementSystem {
    public static void main(String[] args) {
        Book book = new Book("B101", "The Great Gatsby", "F. Scott Fitzgerald");
        Magazine magazine = new Magazine("M202", "National Geographic", "Various");
        DVD dvd = new DVD("D303", "Inception", "Christopher Nolan");

        book.getItemDetails();
        System.out.println("Loan Duration: " + book.getLoanDuration() + " days");
        book.reserveItem();
        System.out.println();

        magazine.getItemDetails();
        System.out.println("Loan Duration: " + magazine.getLoanDuration() + " days");
        System.out.println();

        dvd.getItemDetails();
        System.out.println("Loan Duration: " + dvd.getLoanDuration() + " days");
        dvd.reserveItem();
    }
}
