package SS15_Bai2.main;

import SS15_Bai2.exception.InvalidCreditsException;
import SS15_Bai2.model.Subject;
import SS15_Bai2.service.SubjectManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Use2 {
    public static void main(String[] args) {
        SubjectManager<Subject> manager = new SubjectManager<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n======= HỆ THỐNG QUẢN LÝ MÔN HỌC =======");
                System.out.println("1. Hiển thị danh sách môn học");
                System.out.println("2. Thêm môn học mới");
                System.out.println("3. Xóa môn học");
                System.out.println("4. Tìm kiếm môn học theo tên");
                System.out.println("5. Lọc môn học theo tín chỉ (> 3 tín)");
                System.out.println("6. Thoát");
                System.out.print("Chọn chức năng (1-6): ");

                int choice;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.err.println("Lỗi: Vui lòng nhập vào một số nguyên từ 1 đến 6!");
                    continue;
                }

                if (choice == 6) {
                    System.out.println("Đã thoát chương trình.");
                    System.exit(0);
                }

                try {
                    switch (choice) {
                        case 1:
                            System.out.println("\n--- DANH SÁCH MÔN HỌC ---");
                            manager.displayAll();
                            break;

                        case 2:
                            System.out.print("Nhập mã môn học: ");
                            String code = scanner.nextLine().trim();
                            System.out.print("Nhập tên môn học: ");
                            String name = scanner.nextLine().trim();
                            System.out.print("Nhập số tín chỉ: ");
                            int credits = Integer.parseInt(scanner.nextLine());

                            if (credits < 0 || credits > 10) {
                                throw new InvalidCreditsException("Lỗi: Số tín chỉ không hợp lệ! Phải nằm trong khoảng từ 0 đến 10.");
                            }

                            System.out.print("Nhập ngày bắt đầu (yyyy-MM-dd): ");
                            LocalDate startDate = LocalDate.parse(scanner.nextLine(), formatter);

                            manager.addSubject(new Subject(code, name, credits, startDate));
                            break;

                        case 3:
                            System.out.print("Nhập mã môn học cần xóa: ");
                            String deleteCode = scanner.nextLine().trim();
                            if (manager.deleteSubject(deleteCode)) {
                                System.out.println("Xóa môn học thành công!");
                            } else {
                                System.out.println("Lỗi: Không tìm thấy môn học có mã: " + deleteCode);
                            }
                            break;

                        case 4:
                            System.out.print("Nhập tên môn học cần tìm: ");
                            String searchName = scanner.nextLine().trim();
                            manager.searchByName(searchName);
                            break;

                        case 5:
                            System.out.println("\n--- CÁC MÔN HỌC CÓ TÍN CHỈ > 3 ---");
                            manager.filterHighCredits();
                            break;

                        default:
                            System.out.println("Chức năng không hợp lệ, vui lòng chọn lại từ 1 đến 6.");
                    }
                } catch (DateTimeParseException e) {
                    System.err.println("Lỗi định dạng ngày! Vui lòng nhập đúng mẫu yyyy-MM-dd (Ví dụ: 2026-09-05).");
                } catch (NumberFormatException e) {
                    System.err.println("Lỗi dữ liệu số! Số tín chỉ phải là một số nguyên dương.");
                } catch (InvalidCreditsException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
}