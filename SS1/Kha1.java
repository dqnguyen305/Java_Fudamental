import java.util.Scanner;

public class Kha1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Nhập bán kính của hình tròn (radius): ");
        double radius = input.nextDouble();
        double area = radius * radius * 3.14;

        System.out.println("Diện tích của hình tròn là: " + area);

        input.close();
    }
}