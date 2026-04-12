import java.util.Scanner;

public class Gioi1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Nhập phân số thứ nhất:");
        System.out.print("Tử số 1: ");
        int tu1 = scanner.nextInt();
        System.out.print("Mẫu số 1: ");
        int mau1 = scanner.nextInt();

        System.out.println("Nhập phân số thứ hai:");
        System.out.print("Tử số 2: ");
        int tu2 = scanner.nextInt();
        System.out.print("Mẫu số 2: ");
        int mau2 = scanner.nextInt();

        if (mau1 == 0 || mau2 == 0) {
            System.out.println("Lỗi: Mẫu số phải khác 0!");
        } else {
            int tuTong = tu1 * mau2 + tu2 * mau1;
            int mauTong = mau1 * mau2;

            System.out.println("\n--- Kết quả ---");
            System.out.println("Phân số 1: " + tu1 + "/" + mau1);
            System.out.println("Phân số 2: " + tu2 + "/" + mau2);
            System.out.println("Tổng hai phân số là: " + tuTong + "/" + mauTong);
        }

        scanner.close();
    }
}