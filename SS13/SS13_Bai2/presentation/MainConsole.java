package SS13_Bai2.presentation;

import SS13_Bai2.business.AttendanceManager;
import SS13_Bai2.model.Student;
import java.util.Scanner;

public class MainConsole {
    public static void main(String[] args) {
        AttendanceManager manager = new AttendanceManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== QUẢN LÝ ĐIỂM DANH =====");
            System.out.println("1. Thêm sinh viên");
            System.out.println("2. Sửa sinh viên ");
            System.out.println("3. Xóa sinh viên ");
            System.out.println("4. Hiển thị danh sách");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    String id;
                    while (true) {
                        System.out.print("Nhập mã sinh viên: ");
                        id = scanner.nextLine();
                        if (!id.trim().isEmpty()) {
                            break;
                        }
                        System.out.println("Không được để trống!");
                    }

                    String name;
                    while (true) {
                        System.out.print("Nhập tên sinh viên: ");
                        name = scanner.nextLine();
                        if (!name.trim().isEmpty()) {
                            break;
                        }
                        System.out.println("Không được để trống!");
                    }
                    manager.add(new Student(id, name));
                    System.out.println("Thêm thành công!");
                    break;

                case 2:
                    System.out.print("Nhập mã sinh viên (ID) cần sửa: ");
                    String updateId = scanner.nextLine();
                    int updateIndex = manager.findIndexById(updateId);

                    if (updateIndex == -1) {
                        System.out.println("Không tìm thấy sinh viên có mã này!");
                    } else {
                        String newName;
                        while (true) {
                            System.out.print("Nhập tên mới: ");
                            newName = scanner.nextLine();
                            if (!newName.trim().isEmpty()) {
                                break;
                            }
                            System.out.println("Không được để trống!");
                        }
                        manager.update(updateIndex, new Student(updateId, newName));
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã sinh viên (ID) cần xóa: ");
                    String deleteId = scanner.nextLine();
                    int deleteIndex = manager.findIndexById(deleteId);

                    if (deleteIndex == -1) {
                        System.out.println("Không tìm thấy sinh viên có mã này!");
                    } else {
                        manager.delete(deleteIndex);
                    }
                    break;

                case 4:
                    System.out.println("\n--- DANH SÁCH SINH VIÊN ĐIỂM DANH ---");
                    manager.display();
                    break;

                case 5:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);

        scanner.close();
    }
}