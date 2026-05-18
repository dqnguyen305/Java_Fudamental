package SS12_Bai2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Use2 {
    private static List<Asset> assetList = new ArrayList<>();

    public static void showValue(Asset a) {
        System.out.println(a.toString());
        System.out.printf("   => Giá trị hiện tại sau khấu hao: %,.0f VNĐ\n", a.getMarketValue());
    }

    public static void search(String assetCode) {
        boolean found = false;
        for (Asset asset : assetList) {
            if (asset.getAssetCode().equalsIgnoreCase(assetCode)) {
                showValue(asset);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("❌ Không tìm thấy tài sản nào có mã: " + assetCode);
        }
    }

    public static void search(double minPrice) {
        boolean found = false;
        for (Asset asset : assetList) {
            if (asset.getPurchasePrice() > minPrice) {
                showValue(asset);
                found = true;
            }
        }
        if (!found) {
            System.out.printf("❌ Không có tài sản nào có giá lớn hơn %,.0f VNĐ\n", minPrice);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("\n======= HỆ THỐNG QUẢN LÝ TÀI SẢN (SS12_BAI2) =======");
            System.out.println("1. Nhập tài sản mới");
            System.out.println("2. Xuất báo cáo tài sản");
            System.out.println("3. Tìm kiếm tài sản (Overloading)");
            System.out.println("4. Sửa giá mua gốc");
            System.out.println("5. Thoát");
            System.out.print("Mời bạn chọn chức năng (1-5): ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("--- NHẬP TÀI SẢN MỚI ---");
                    System.out.println("1. Máy tính (Computer)");
                    System.out.println("2. Thiết bị mạng (NetworkDevice)");
                    System.out.print("Chọn loại tài sản: ");
                    int type = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nhập mã tài sản: ");
                    String code = scanner.nextLine();

                    boolean isExist = false;
                    for (Asset a : assetList) {
                        if (a.getAssetCode().equalsIgnoreCase(code)) {
                            isExist = true;
                            break;
                        }
                    }
                    if (isExist) {
                        System.out.println("❌ Lỗi: Mã tài sản này đã tồn tại!");
                        break;
                    }

                    System.out.print("Nhập tên tài sản: ");
                    String name = scanner.nextLine();
                    System.out.print("Nhập giá mua gốc: ");
                    double price = scanner.nextDouble();

                    if (type == 1) {
                        System.out.print("Nhập dung lượng RAM (GB): ");
                        int ram = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nhập thông số CPU: ");
                        String cpu = scanner.nextLine();
                        assetList.add(new Computer(code, name, price, ram, cpu));
                        System.out.println("🎉 Thêm máy tính thành công!");
                    } else if (type == 2) {
                        System.out.print("Nhập số lượng cổng mạng: ");
                        int ports = scanner.nextInt();
                        assetList.add(new NetworkDevice(code, name, price, ports));
                        System.out.println("🎉 Thêm thiết bị mạng thành công!");
                    } else {
                        System.out.println("❌ Lựa chọn loại tài sản không hợp lệ!");
                    }
                    break;

                case 2:
                    System.out.println("\n--- BÁO CÁO KHẤU HAO TÀI SẢN ---");
                    if (assetList.isEmpty()) {
                        System.out.println("Hệ thống chưa có dữ liệu tài sản!");
                    } else {
                        for (Asset asset : assetList) {
                            showValue(asset);
                            System.out.println("-------------------------------------------------");
                        }
                    }
                    break;

                case 3:
                    System.out.println("--- TÌM KIẾM TÀI SẢN ---");
                    System.out.println("1. Tìm chính xác theo Mã tài sản (String)");
                    System.out.println("2. Tìm tài sản có giá mua lớn hơn mức chỉ định (double)");
                    System.out.print("Chọn tiêu chí tìm kiếm: ");
                    int searchType = scanner.nextInt();
                    scanner.nextLine();

                    if (searchType == 1) {
                        System.out.print("Nhập mã tài sản cần tìm: ");
                        String searchCode = scanner.nextLine();
                        search(searchCode);
                    } else if (searchType == 2) {
                        System.out.print("Nhập mức giá sàn: ");
                        double minPrice = scanner.nextDouble();
                        search(minPrice);
                    } else {
                        System.out.println("❌ Tiêu chí không hợp lệ!");
                    }
                    break;

                case 4:
                    System.out.println("--- CẬP NHẬT GIÁ MUA GỐC ---");
                    System.out.print("Nhập mã tài sản muốn sửa giá: ");
                    String editCode = scanner.nextLine();

                    Asset editAsset = null;
                    for (Asset a : assetList) {
                        if (a.getAssetCode().equalsIgnoreCase(editCode)) {
                            editAsset = a;
                            break;
                        }
                    }

                    if (editAsset == null) {
                        System.out.println("❌ Không tìm thấy tài sản có mã: " + editCode);
                    } else {
                        System.out.printf("Tài sản hiện tại: %s (Giá gốc cũ: %,.0f VNĐ)\n", editAsset.getName(), editAsset.getPurchasePrice());
                        System.out.print("Nhập giá mua gốc mới: ");
                        double newPrice = scanner.nextDouble();
                        editAsset.setPurchasePrice(newPrice);
                        System.out.println("🎉 Cập nhật giá mua gốc thành công!");
                    }
                    break;

                case 5:
                    System.out.println("👋 Đang đóng hệ thống quản lý tài sản... Tạm biệt!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("❌ Lựa chọn sai, vui lòng nhập lại số từ 1 đến 5!");
            }
        }
    }
}