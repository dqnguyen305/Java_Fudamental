public class SS8_Book {
    private String title;
    private String author;
    private double price;

    public SS8_Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    public void printInfo() {
        System.out.println("Title: " + title + ", Author: " + author + ", Price: $" + price);
    }
    public static void main(String[] args) {
        SS8_Book book1 = new SS8_Book("The Great Gatsby", "F. Scott Fitzgerald", 10.99);
        book1.printInfo();
    }
}
