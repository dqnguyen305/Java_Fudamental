package SS14_Bai4.main;

import SS14_Bai4.exception.InvalidPhoneNumberLengthException;
import SS14_Bai4.model.PhoneError;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Use4 {
    public static void main(String[] args) {
        List<String> validPhones = new ArrayList<>();
        List<PhoneError> invalidPhones = new ArrayList<>();

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Nhập danh sách số điện thoại (phân tách bằng dấu phẩy):");
            String input = scanner.nextLine();

            String[] rawPhones = input.split(",");

            for (String rawPhone : rawPhones) {
                String phone = rawPhone.trim();

                if (phone.isEmpty()) {
                    continue;
                }

                try {
                    InvalidPhoneNumberLengthException.validate(phone);
                    validPhones.add(phone);
                } catch (InvalidPhoneNumberLengthException e) {
                    invalidPhones.add(new PhoneError(phone, e.getMessage()));
                }
            }
        }

        System.out.println("\nSố điện thoại hợp lệ:");
        if (validPhones.isEmpty()) {
            System.out.println("- (Không có)");
        } else {
            for (String phone : validPhones) {
                System.out.println("- " + phone);
            }
        }

        System.out.println("\nSố điện thoại không hợp lệ:");
        if (invalidPhones.isEmpty()) {
            System.out.println("- (Không có)");
        } else {
            for (PhoneError error : invalidPhones) {
                System.out.println("- " + error);
            }
        }
    }
}