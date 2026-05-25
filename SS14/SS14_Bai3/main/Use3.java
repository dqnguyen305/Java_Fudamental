package SS14_Bai3.main;

import SS14_Bai3.service.StringConversionService;
import java.util.Scanner;

public class Use3 {
    public static void main(String[] args) {
        StringConversionService conversionService = new StringConversionService();

        System.out.println("Nhập các chuỗi (Nhập 'exit' để dừng và xem kết quả):");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.print("Nhập chuỗi: ");
                String input = scanner.nextLine().trim();

                if ("exit".equalsIgnoreCase(input)) {
                    break;
                }

                conversionService.processString(input);
            }
        }

        System.out.println("\n--- THỐNG KÊ KẾT QUẢ ---");
        System.out.println("Số lượng chuỗi hợp lệ: " + conversionService.getValidCount());
        System.out.println("Số lượng chuỗi không hợp lệ: " + conversionService.getInvalidCount());
        System.out.println("Danh sách các số nguyên chuyển đổi thành công: " + conversionService.getValidNumbers());
    }
}