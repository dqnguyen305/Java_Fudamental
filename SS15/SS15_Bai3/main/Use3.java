package SS15_Bai3.main;

import SS15_Bai3.exception.InvalidPriceException;
import SS15_Bai3.exception.OrderNotFoundException;
import SS15_Bai3.exception.ProductNotFoundException;
import SS15_Bai3.model.Order;
import SS15_Bai3.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Use3 {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        Map<Integer, Order> orderMap = new HashMap<>();

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n=============== MENU ===============");
                System.out.println("1. Thêm sản phẩm");
                System.out.println("2. Xóa sản phẩm");
                System.out.println("3. Hiển thị sản phẩm");
                System.out.println("4. Tạo đơn hàng");
                System.out.println("5. Thêm sản phẩm vào đơn hàng");
                System.out.println("6. Hiển thị đơn hàng");
                System.out.println("0. Thoát");
                System.out.println("====================================");
                System.out.print("Lựa chọn của bạn: ");

                int choice;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.err.println("Lỗi: Vui lòng nhập số tương ứng với menu!");
                    continue;
                }

                if (choice == 0) {
                    System.out.println("Đã thoát chương trình.");
                    break;
                }

                try {
                    switch (choice) {
                        case 1:
                            System.out.print("Nhập ID sản phẩm: ");
                            int id = Integer.parseInt(scanner.nextLine());
                            System.out.print("Nhập tên sản phẩm: ");
                            String name = scanner.nextLine().trim();
                            System.out.print("Nhập giá sản phẩm: ");
                            double price = Double.parseDouble(scanner.nextLine());

                            if (price <= 0) {
                                throw new InvalidPriceException("Lỗi: Giá sản phẩm phải lớn hơn 0!");
                            }

                            productList.add(new Product(id, name, price));
                            System.out.println("Thêm sản phẩm thành công!");
                            break;

                        case 2:
                            System.out.print("Nhập ID sản phẩm cần xóa: ");
                            int deleteId = Integer.parseInt(scanner.nextLine());

                            boolean removed = productList.removeIf(p -> p.getId() == deleteId);
                            if (!removed) {
                                throw new ProductNotFoundException("Lỗi: Không tìm thấy sản phẩm có ID " + deleteId + " để xóa!");
                            }
                            System.out.println("Xóa sản phẩm thành công!");
                            break;

                        case 3:
                            System.out.println("\n--- DANH SÁCH SẢN PHẨM ---");
                            if (productList.isEmpty()) {
                                System.out.println("Không có sản phẩm nào.");
                            } else {
                                productList.forEach(System.out::println);
                            }
                            break;

                        case 4:
                            System.out.print("Nhập mã (ID) đơn hàng muốn tạo: ");
                            int orderId = Integer.parseInt(scanner.nextLine());

                            if (orderMap.containsKey(orderId)) {
                                System.out.println("Đơn hàng này đã tồn tại trong hệ thống.");
                            } else {
                                orderMap.put(orderId, new Order(orderId));
                                System.out.println("Tạo đơn hàng số " + orderId + " thành công!");
                            }
                            break;

                        case 5:
                            System.out.print("Nhập mã đơn hàng: ");
                            int targetOrderId = Integer.parseInt(scanner.nextLine());
                            if (!orderMap.containsKey(targetOrderId)) {
                                throw new OrderNotFoundException("Lỗi: Đơn hàng số " + targetOrderId + " không tồn tại!");
                            }

                            System.out.print("Nhập ID sản phẩm muốn thêm: ");
                            int targetProductId = Integer.parseInt(scanner.nextLine());

                            Product foundProduct = productList.stream()
                                    .filter(p -> p.getId() == targetProductId)
                                    .findFirst()
                                    .orElseThrow(() -> new ProductNotFoundException("Lỗi: Sản phẩm có ID " + targetProductId + " không tồn tại!"));

                            orderMap.get(targetOrderId).addProduct(foundProduct);
                            System.out.println("Đã thêm sản phẩm [" + foundProduct.getName() + "] vào đơn hàng số " + targetOrderId);
                            break;

                        case 6:
                            System.out.print("Nhập mã đơn hàng cần xem: ");
                            int searchOrderId = Integer.parseInt(scanner.nextLine());

                            Order order = orderMap.get(searchOrderId);
                            if (order == null) {
                                throw new OrderNotFoundException("Lỗi: Đơn hàng số " + searchOrderId + " không tồn tại!");
                            }

                            System.out.println("\n--- THÔNG TIN ĐƠN HÀNG ---");
                            System.out.println(order);
                            System.out.println("Chi tiết các sản phẩm trong đơn:");
                            if (order.getProducts().isEmpty()) {
                                System.out.println("  (Chưa có sản phẩm nào)");
                            } else {
                                order.getProducts().forEach(p -> System.out.println("  - " + p));
                            }
                            break;

                        default:
                            System.out.println("Lựa chọn không hợp lệ, vui lòng nhập lại.");
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Lỗi dữ liệu: Bạn nhập sai định dạng số!");
                } catch (InvalidPriceException | ProductNotFoundException | OrderNotFoundException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
}