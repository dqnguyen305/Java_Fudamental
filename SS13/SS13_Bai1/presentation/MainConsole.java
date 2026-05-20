package SS13_Bai1.presentation;

import SS13_Bai1.model.Person;
import SS13_Bai1.business.UserManager;
import java.util.List;
import java.util.Scanner;

public class MainConsole {
    public static void main(String[] args) {
        UserManager userManager = new UserManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n******* QUẢN LÝ NGƯỜI DÙNG ****");
            System.out.println("1. Thêm người dùng");
            System.out.println("2. Xóa người dùng ");
            System.out.println("3. Hiển thị danh sách người dùng");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    String name;
                    while (true) {
                        System.out.print("Nhập tên người dùng: ");
                        name = scanner.nextLine();
                        if (!name.trim().isEmpty()) {
                            break;
                        }
                        System.out.println("Tên người dùng không được để trống. Vui lòng nhập lại!");
                    }

                    String email;
                    while (true) {
                        System.out.print("Nhập email: ");
                        email = scanner.nextLine();
                        if (!email.trim().isEmpty()) {
                            break;
                        }
                        System.out.println("Email không được để trống. Vui lòng nhập lại!");
                    }

                    String phone;
                    while (true) {
                        System.out.print("Nhập số điện thoại: ");
                        phone = scanner.nextLine();
                        if (!phone.trim().isEmpty()) {
                            break;
                        }
                        System.out.println("Số điện thoại không được để trống. Vui lòng nhập lại!");
                    }

                    Person person = new Person(name, email, phone);
                    userManager.addUser(person);
                    System.out.println("Thêm thành công!");
                    break;

                case 2:
                    System.out.print("Nhập email cần xóa: ");
                    String emailToDelete = scanner.nextLine();
                    boolean isDeleted = userManager.deleteUserByEmail(emailToDelete);
                    if (isDeleted) {
                        System.out.println("Xóa thành công!");
                    } else {
                        System.out.println("Không tìm thấy email phù hợp.");
                    }
                    break;

                case 3:
                    System.out.println("\n--- DANH SÁCH NGƯỜI DÙNG ---");
                    List<Person> list = userManager.getAllUsers();
                    if (list.isEmpty()) {
                        System.out.println("Danh sách trống.");
                    } else {
                        for (Person p : list) {
                            System.out.println(p);
                        }
                    }
                    break;

                case 4:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 0);

        scanner.close();
    }
}