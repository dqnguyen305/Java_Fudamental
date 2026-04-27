import java.util.Scanner;

public class SS5_Kha1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Nhập địa chỉ email: ");
        String email = scanner.nextLine();

        email = email.trim();

        String regex = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.]+\\.[a-zA-Z]{2,6}$";

        if (email.matches(regex)) {
            System.out.println("Email hợp lệ");
        } else {
            System.out.println("Email không hợp lệ");
        }

        scanner.close();
    }
}
