package SS12_Bai3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Use3 {
    public static void main(String[] args) {
        List<Drink> menu = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n======= HỆ THỐNG QUẢN LÝ QUÁN CÀ PHÊ (SS12_BAI3) =======");
            System.out.println("1. Thêm món mới vào Menu");
            System.out.println("2. Hiển thị danh sách Menu");
            System.out.println("3. Áp dụng mã giảm giá toàn hệ thống");
            System.out.println("4. Xóa món khỏi Menu");
            System.out.println("5. Thống kê giá tiền trung bình");
            System.out.println("6. Thoát");
            System.out.print("Mời bạn chọn chức năng (1-6): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("--- THÊM MÓN MỚI ---");
                    System.out.println("1. Cà phê (Coffee)");
                    System.out.println("2. Trà trái cây (FruitTea)");
                    System.out.print("Chọn loại đồ uống: ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nhập mã món (ID): ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    boolean isExist = false;
                    for (Drink d : menu) {
                        if (d.getId() == id) {
                            isExist = true;
                            break;
                        }
                    }
                    if (isExist) {
                        System.out.println("❌ Lỗi: Mã món này đã tồn tại!");
                        break;
                    }

                    System.out.print("Nhập tên đồ uống: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập giá bán: ");
                    double price = scanner.nextDouble();

                    if (type == 1) {
                        menu.add(new Coffee(id, name, price));
                        System.out.println("🎉 Thêm cà phê vào menu thành công!");
                    } else if (type == 2) {
                        menu.add(new FruitTea(id, name, price));
                        System.out.println("🎉 Thêm trà trái cây vào menu thành công!");
                    } else {
                        System.out.println("❌ Lựa chọn loại đồ uống không hợp lệ!");
                    }
                    break;

                case 2:
                    System.out.println("\n--- DANH MỤC MENU ĐỒ UỐNG ---");
                    if (menu.isEmpty()) {
                        System.out.println("Menu hiện tại trống!");
                    } else {
                        for (Drink drink : menu) {
                            drink.showInfo();
                        }
                    }
                    break;

                case 3:
                    System.out.println("--- ÁP DỤNG CHƯƠNG TRÌNH GIẢM GIÁ ---");
                    if (menu.isEmpty()) {
                        System.out.println("❌ Menu trống, không thể áp dụng giảm giá!");
                        break;
                    }
                    System.out.print("Nhập phần trăm giảm giá (%): ");
                    double percent = scanner.nextDouble();

                    for (Drink drink : menu) {
                        if (drink instanceof IPromotion) {
                            ((IPromotion) drink).applyDiscount(percent);
                        }
                    }
                    System.out.printf("🎉 Đã cập nhật giảm giá %,.0f%% cho toàn bộ món ăn trong Menu!\n", percent);
                    break;

                case 4:
                    System.out.println("--- XÓA MÓN KHỎI MENU ---");
                    System.out.print("Nhập mã món cần xóa: ");
                    int deleteId = scanner.nextInt();

                    Drink deleteDrink = null;
                    for (Drink d : menu) {
                        if (d.getId() == deleteId) {
                            deleteDrink = d;
                            break;
                        }
                    }

                    if (deleteDrink == null) {
                        System.out.println("❌ Không tìm thấy món nào có mã số: " + deleteId);
                    } else {
                        menu.remove(deleteDrink);
                        System.out.println("🗑️ Đã xóa món \"" + deleteDrink.getName() + "\" ra khỏi danh mục!");
                    }
                    break;

                case 5:
                    System.out.println("--- THỐNG KÊ DOANH NGHIỆP ---");
                    if (menu.isEmpty()) {
                        System.out.println("Không thể tính toán do menu chưa có món ăn nào!");
                    } else {
                        double totalSum = 0;
                        for (Drink drink : menu) {
                            totalSum += drink.getPrice();
                        }
                        double averagePrice = totalSum / menu.size();
                        System.out.printf("📊 Số lượng món trong danh mục: %d món\n", menu.size());
                        System.out.printf("📊 Giá bán trung bình của một món: %,.2f VNĐ\n", averagePrice);
                    }
                    break;

                case 6:
                    System.out.println("👋 Đang tắt ứng dụng quản lý quán cà phê... Tạm biệt!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("❌ Lựa chọn sai, vui lòng nhập lại số từ 1 đến 6!");
            }
        }
    }
}