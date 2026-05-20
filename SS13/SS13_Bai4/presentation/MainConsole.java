package SS13_Bai4.presentation;

import SS13_Bai4.business.OrderManager;
import SS13_Bai4.model.Order;
import java.util.Scanner;

public class MainConsole {
    public static void main(String[] args) {
        OrderManager manager = new OrderManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== QUẢN LÝ ĐƠN HÀNG =====");
            System.out.println("1. Thêm đơn hàng");
            System.out.println("2. Sửa đơn hàng");
            System.out.println("3. Xóa đơn hàng");
            System.out.println("4. Hiển thị danh sách đơn hàng");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    String id;
                    while (true) {
                        System.out.print("Nhập mã đơn hàng: ");
                        id = scanner.nextLine();
                        if (!id.trim().isEmpty()) {
                            break;
                        }
                        System.out.println("Không được để trống!");
                    }

                    String name;
                    while (true) {
                        System.out.print("Nhập tên khách hàng: ");
                        name = scanner.nextLine();
                        if (!name.trim().isEmpty()) {
                            break;
                        }
                        System.out.println("Không được để trống!");
                    }

                    manager.add(new Order(id, name));
                    System.out.println("Thêm thành công!");
                    break;

                case 2:
                    System.out.print("Nhập mã đơn hàng cần sửa: ");
                    String updateId = scanner.nextLine();
                    int updateIndex = manager.findIndexByID(updateId);

                    if (updateIndex == -1) {
                        System.out.println("Không tìm thấy đơn hàng với mã này!");
                    } else {
                        String newName;
                        while (true) {
                            System.out.print("Nhập tên khách hàng mới: ");
                            newName = scanner.nextLine();
                            if (!newName.trim().isEmpty()) {
                                break;
                            }
                            System.out.println("Không được để trống!");
                        }
                        manager.update(updateIndex, new Order(updateId, newName));
                    }
                    break;

                case 3:
                    manager.display();
                    System.out.print("Nhập mã đơn hàng cần xóa: ");
                    String deleteId = scanner.nextLine();
                    int deleteIndex = manager.findIndexByID(deleteId);

                    if (deleteIndex == -1) {
                        System.out.println("Không tìm thấy đơn hàng với mã này!");
                    } else {
                        manager.delete(deleteIndex);
                    }
                    break;

                case 4:
                    System.out.println("\n--- DANH SÁCH ĐƠN HÀNG ---");
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