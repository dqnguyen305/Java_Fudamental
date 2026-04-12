import java.util.Scanner;

public class Kha2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập số thứ nhất: ");
        int a = scanner.nextInt();

        System.out.print("Nhập số thứ hai: ");
        int b = scanner.nextInt();
        int tong = a + b;
        int hieu = a - b;
        int tich = a * b;
        if (b != 0) {
            int thuong = a / b;
            int du = a % b;

            System.out.println("\n--- Kết quả ---");
            System.out.println("Tổng = " + tong);
            System.out.println("Hiệu = " + hieu);
            System.out.println("Tích = " + tich);
            System.out.println("Thương = " + thuong);
            System.out.println("Số dư = " + du);
        } else {
            System.out.println("\nKhông thể thực hiện phép chia vì số thứ hai bằng 0!");
        }

        scanner.close();
    }
}