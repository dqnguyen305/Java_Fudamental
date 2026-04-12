import java.util.Scanner;

public class Gioi2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập chiều rộng (width): ");
        float width = scanner.nextFloat();

        System.out.print("Nhập chiều cao (height): ");
        float height = scanner.nextFloat();

        float area = width * height;
        float perimeter = 2 * (width + height);

        System.out.println("\n--- Kết quả ---");
        System.out.println("Chiều rộng: " + width);
        System.out.println("Chiều cao: " + height);
        System.out.println("Diện tích hình chữ nhật: " + area);
        System.out.println("Chu vi hình chữ nhật: " + perimeter);

        scanner.close();
    }
}