package SS10_Bai3;

public class Use3 {
    public static void main(String[] args) {
        Computer c = new Computer();
        double price1 = c.calculatePrice(1000);
        System.out.println("Price 1: " + price1);
        double price2 = c.calculatePrice(1000, 100);
        System.out.println("Price 2: " + price2);
        double price3 = c.calculatePrice(1000, 100, 50);
        System.out.println("Price 3: " + price3);
    }
}
