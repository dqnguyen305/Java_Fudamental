import java.util.Random;
import java.util.Scanner;

public class SS5_Gioi2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("Nhập độ dài n: ");
        int n = scanner.nextInt();

        if (n >= 1 && n <= 1000) {
            String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
            char[] result = new char[n];

            for (int i = 0; i < n; i++) {
                int index = random.nextInt(characters.length());
                result[i] = characters.charAt(index);
            }

            String finalString = new String(result);
            System.out.println("Chuỗi ngẫu nhiên: " + finalString);
        } else {
            System.out.println("n phải nằm trong khoảng [1, 1000]");
        }

        scanner.close();
    }
}
