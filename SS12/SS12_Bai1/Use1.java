package SS12_Bai1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Use1 {
    public static void main(String[] args) {
        List<Staff> staffList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n======= HỆ THỐNG QUẢN LÝ TRUNG TÂM =======");
            System.out.println("1. Thêm mới nhân sự");
            System.out.println("2. Hiển thị danh sách nhân sự (Đa hình)");
            System.out.println("3. Cập nhật thông tin theo ID");
            System.out.println("4. Xóa nhân sự theo ID");
            System.out.println("5. Thoát chương trình");
            System.out.print("Mời bạn chọn chức năng (1-5): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("--- THÊM MỚI NHÂN SỰ ---");
                    System.out.println("1. Thêm Giảng viên (Lecturer)");
                    System.out.println("2. Thêm Nhân viên hành chính (AdminStaff)");
                    System.out.print("Chọn loại nhân sự: ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nhập ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    boolean isExist = false;
                    for (Staff s : staffList) {
                        if (s.getId() == id) {
                            isExist = true;
                            break;
                        }
                    }
                    if (isExist) {
                        System.out.println("❌ Lỗi: ID này đã tồn tại trên hệ thống!");
                        break;
                    }

                    System.out.print("Nhập họ và tên: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập lương cơ bản: ");
                    double baseSalary = scanner.nextDouble();

                    if (type == 1) {
                        System.out.print("Nhập số giờ dạy: ");
                        int hours = scanner.nextInt();
                        staffList.add(new Lecturer(id, name, baseSalary, hours));
                        System.out.println("🎉 Thêm giảng viên thành công!");
                    } else if (type == 2) {
                        System.out.print("Nhập tiền thưởng: ");
                        double bonus = scanner.nextDouble();
                        staffList.add(new AdminStaff(id, name, baseSalary, bonus));
                        System.out.println("🎉 Thêm nhân viên hành chính thành công!");
                    } else {
                        System.out.println("❌ Lựa chọn không hợp lệ!");
                    }
                    break;

                case 2:
                    System.out.println("\n--- DANH SÁCH NHÂN SỰ TOÀN TRUNG TÂM ---");
                    if (staffList.isEmpty()) {
                        System.out.println("Danh sách trống!");
                    } else {
                        for (Staff staff : staffList) {
                            staff.showInfo();
                            System.out.println("-------------------------------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.println("--- CẬP NHẬT THÔNG TIN NHÂN SỰ ---");
                    System.out.print("Nhập ID cần sửa: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    Staff updateStaff = null;
                    for (Staff s : staffList) {
                        if (s.getId() == updateId) {
                            updateStaff = s;
                            break;
                        }
                    }

                    if (updateStaff == null) {
                        System.out.println("❌ Không tìm thấy nhân sự có ID: " + updateId);
                    } else {
                        System.out.print("Nhập tên mới: ");
                        String newName = scanner.nextLine();
                        System.out.print("Nhập lương cơ bản mới: ");
                        double newBaseSalary = scanner.nextDouble();

                        updateStaff.setName(newName);
                        updateStaff.setBaseSalary(newBaseSalary);

                        if (updateStaff instanceof Lecturer) {
                            System.out.print("Nhập số giờ dạy mới: ");
                            int newHours = scanner.nextInt();
                            ((Lecturer) updateStaff).setTeachingHours(newHours);
                        } else if (updateStaff instanceof AdminStaff) {
                            System.out.print("Nhập tiền thưởng mới: ");
                            double newBonus = scanner.nextDouble();
                            ((AdminStaff) updateStaff).setBonus(newBonus);
                        }
                        System.out.println("🎉 Cập nhật thông tin thành công!");
                    }
                    break;

                case 4:
                    System.out.println("--- XÓA NHÂN SỰ KHỎI HỆ THỐNG ---");
                    System.out.print("Nhập ID cần xóa: ");
                    int deleteId = scanner.nextInt();

                    Staff deleteStaff = null;
                    for (Staff s : staffList) {
                        if (s.getId() == deleteId) {
                            deleteStaff = s;
                            break;
                        }
                    }

                    if (deleteStaff == null) {
                        System.out.println("❌ Không tìm thấy nhân sự có ID: " + deleteId);
                    } else {
                        staffList.remove(deleteStaff);
                        System.out.println("🗑️ Đã xóa nhân sự có ID " + deleteId + " khỏi hệ thống thành công!");
                    }
                    break;

                case 5:
                    System.out.println("👋 Đang đóng hệ thống... Tạm biệt!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("❌ Lựa chọn sai, vui lòng nhập lại từ 1 đến 5!");
            }
        }
    }
}