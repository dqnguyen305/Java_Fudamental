package SS14_Bai1.main;

import SS14_Bai1.exception.InvalidNumberException;
import SS14_Bai1.service.PrimeService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class use1 {
    public static void main(String[] args) {
        PrimeService primeService = new PrimeService();

        System.out.print("Nhập vào một số nguyên dương để kiểm tra: ");

        try (Scanner scanner = new Scanner(System.in)) {
            if (!scanner.hasNextInt()) {
                throw new InputMismatchException("Lỗi: Dữ liệu nhập vào không phải là số nguyên!");
            }

            int number = scanner.nextInt();

            if (number <= 0) {
                throw new InvalidNumberException("Lỗi: Số nhập vào phải lớn hơn 0. Các số ≤ 0 không hợp lệ để kiểm tra số nguyên tố!");
            }

            if (primeService.isPrime(number)) {
                System.out.println("Kết quả: " + number + " LÀ số nguyên tố.");
            } else {
                System.out.println("Kết quả: " + number + " KHÔNG PHẢI là số nguyên tố.");
            }

        } catch (InputMismatchException | InvalidNumberException e) {
            System.err.println(e.getMessage());
        }
    }
}