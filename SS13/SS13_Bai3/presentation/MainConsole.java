package SS13_Bai3.presentation;

import SS13_Bai3.business.InvoiceManager;
import SS13_Bai3.model.Invoice;
import java.util.Scanner;

public class MainConsole {
    public static void main(String[] args) {
        InvoiceManager manager = new InvoiceManager();
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n***************** MENU QUẢN LÝ HÓA ĐƠN *****************");
            System.out.println("1. Thêm hóa đơn");
            System.out.println("2. Sửa hóa đơn");
            System.out.println("3. Xóa hóa đơn");
            System.out.println("4. Hiển thị danh sách hóa đơn");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    String id;
                    while (true) {
                        System.out.print("Nhập mã hóa đơn: ");
                        id = scanner.nextLine();
                        if (!id.trim().isEmpty()) {
                            break;
                        }
                        System.out.println("Không được để trống!");
                    }

                    double amount;
                    while (true) {
                        System.out.print("Nhập số tiền: ");
                        if (scanner.hasNextDouble()) {
                            amount = scanner.nextDouble();
                            scanner.nextLine();
                            if (amount >= 0) {
                                break;
                            }
                            System.out.println("Vui lòng nhập số thực >= 0!");
                        } else {
                            System.out.println("Vui lòng nhập một số hợp lệ!");
                            scanner.nextLine();
                        }
                    }

                    manager.add(new Invoice(id, amount));
                    System.out.println("Thêm thành công!");
                    break;

                case 2:
                    System.out.print("Nhập mã hóa đơn cần sửa: ");
                    String updateId = scanner.nextLine();
                    int updateIndex = manager.findIndexById(updateId);

                    if (updateIndex == -1) {
                        System.out.println("Không tìm thấy hóa đơn có mã này!");
                    } else {
                        double newAmount;
                        while (true) {
                            System.out.print("Nhập số tiền mới: ");
                            if (scanner.hasNextDouble()) {
                                newAmount = scanner.nextDouble();
                                scanner.nextLine();
                                if (newAmount >= 0) {
                                    break;
                                }
                                System.out.println("Số tiền phải lớn hơn hoặc bằng 0!");
                            } else {
                                System.out.println("Vui lòng nhập một số hợp lệ!");
                                scanner.nextLine();
                            }
                        }
                        manager.update(updateIndex, new Invoice(updateId, newAmount));
                    }
                    break;

                case 3:
                    manager.display();
                    System.out.print("Nhập mã hóa đơn cần xóa: ");
                    String deleteId = scanner.nextLine();
                    int deleteIndex = manager.findIndexById(deleteId);

                    if (deleteIndex == -1) {
                        System.out.println("Không tìm thấy hóa đơn có mã này!");
                    } else {
                        manager.delete(deleteIndex);
                    }
                    break;

                case 4:
                    System.out.println("\n--- DANH SÁCH HÓA ĐƠN ---");
                    manager.display();
                    break;

                case 5:
                    System.out.println("Kết thúc chương trình.");
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (choice != 5);

        scanner.close();
    }
}