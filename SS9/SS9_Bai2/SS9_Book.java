public class SS9_Book {
    private String title;
    private String author;
    private double price;

    public SS9_Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void printInfo() {
        System.out.printf("Title: %s%n", title);
        System.out.printf("Author: %s%n", author);
        System.out.printf("Price: %.1f%n%n", price);
    }
}
