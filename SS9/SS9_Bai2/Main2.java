public class Main2 {
    public static void main(String[] args) {
        SS9_Book b1 = new SS9_Book("Java", "James", 100.0);
        SS9_Book b2 = new SS9_Book("Python", "Guido", 120.0);
        SS9_Book b3 = new SS9_Book("C++", "Bjarne", 150.0);

        SS9_Book[] list = {b1, b2, b3};
        System.out.println("----- LIST OF BOOKS -----");
        for (SS9_Book book : list) {
            book.printInfo();
        }


    }
}
