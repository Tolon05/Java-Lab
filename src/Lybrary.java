public class Lybrary {
    public static void main(String[] args) {
        PrintedBook printedBook = new PrintedBook("The Great Gatsby", "F. Scott Fitzgerald", 1925, 218, "Scribner");
        EBook eBook = new EBook("Java Programming for Beginners", "John Smith", 2020, 4.5, "PDF");

        printedBook.printBookDetails();

        System.out.println();

        eBook.printBookDetails();
    }
}

class Book {
    private String title;
    private String author;
    private int yearPublished;

    public Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
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

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getBookInfo(){
        return " Title: " + title + "\n Author: " + author + "\n Year Published: " + yearPublished;
    }

    public void printBookDetails() {
        System.out.println("Book Details:");
        System.out.println(getBookInfo());
    }
}

class PrintedBook extends Book{
    private int numberOfPages;
    private String publisher;
    private double price;

    public PrintedBook(String title, String author, int yearPublished, int numberOfPages, String publisher) {
        super(title, author, yearPublished);
        this.numberOfPages = numberOfPages;
        this.publisher = publisher;
        this.price = 1.5 * numberOfPages;
    }

    public PrintedBook(String title, String author, int yearPublished, int numberOfPages, double price) {
        super(title, author, yearPublished);
        this.numberOfPages = numberOfPages;
        this.price = price;
    }

    public String getBookInfo() {
        return super.getBookInfo() + "\n Number of Pages: " + numberOfPages + "\n Publisher: " + publisher + "\n Price: " + price;
    }

    public void printBookDetails() {
        System.out.println("Printed Book Info:\n" + getBookInfo() + "\n" + " Book Type: PrintedBook");
    }

    public void bookType() {
        System.out.println("This is a printed book.");
    }

    public void printBook() {
        System.out.println("Printing the book...");
    }
}

class EBook extends Book{
    private double fileSizeMB;
    private String fileFormat;
    private double price;
    private String[] formats = {"PDF", "EPUB"};

    public EBook(String title, String author, int yearPublished, double fileSizeMB, String fileFormat, double price) {
        super(title, author, yearPublished);
        this.fileSizeMB = fileSizeMB;
        this.fileFormat = fileFormat;
        this.price = price;
    }

    public EBook(String title, String author, int yearPublished, double fileSizeMB, String fileFormat) {
        super(title, author, yearPublished);
        this.fileSizeMB = fileSizeMB;
        this.fileFormat = fileFormat;
        if (fileFormat == "PDF"){
            this.price = 0.5 * fileSizeMB + 10;
        } else if (fileFormat == "EPUB") {
            this.price = 0.5 * fileSizeMB + 15;
        }
    }

    public String getBookInfo() {
        return super.getBookInfo() + "\n File Size: " + fileSizeMB + "\n File Format: " + fileFormat + "\n Price: " + price;
    }

    public void printBookDetails() {
        System.out.println("EBook Info:\n" + getBookInfo() + "\n" + " Book Type: EBook");
    }

    public void bookType() {
        System.out.println("This is an ebook.");
    }
}