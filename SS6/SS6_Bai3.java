import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SS6_Bai3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> danhSachBienSo = new ArrayList<>();
        int luaChon;

        do {
            System.out.println("\n******************** QUẢN LÝ BIỂN SỐ XE ********************");
            System.out.println("1. Thêm các biển số xe");
            System.out.println("2. Hiển thị danh sách biển số xe");
            System.out.println("3. Tìm kiếm biển số xe");
            System.out.println("4. Tìm biển số xe theo mã tỉnh");
            System.out.println("5. Sắp xếp biển số xe tăng dần");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            luaChon = scanner.nextInt();
            scanner.nextLine();

            switch (luaChon) {
                case 1:
                    while (true) {
                        System.out.print("Nhập biển số xe (VD: 30F-123.45, nhập -1 để dừng): ");
                        String bienSo = scanner.nextLine();
                        if (bienSo.equals("-1")) break;
                        danhSachBienSo.add(bienSo.toUpperCase());
                    }
                    break;
                case 2:
                    System.out.println("Danh sách biển số xe: " + danhSachBienSo);
                    break;
                case 3:
                    System.out.print("Nhập biển số cần tìm chính xác: ");
                    String search = scanner.nextLine().toUpperCase();
                    if (danhSachBienSo.contains(search)) {
                        System.out.println("Tìm thấy biển số: " + search);
                    } else {
                        System.out.println("Không tìm thấy biển số này.");
                    }
                    break;
                case 4:
                    System.out.print("Nhập mã tỉnh cần tìm (VD: 29, 30, 51...): ");
                    String maTinh = scanner.nextLine();
                    boolean found = false;
                    System.out.println("Kết quả tìm kiếm theo mã tỉnh " + maTinh + ":");
                    for (String bs : danhSachBienSo) {
                        if (bs.startsWith(maTinh)) {
                            System.out.println(bs);
                            found = true;
                        }
                    }
                    if (!found) System.out.println("Không có biển số nào thuộc mã tỉnh này.");
                    break;
                case 5:
                    Collections.sort(danhSachBienSo);
                    System.out.println("Đã sắp xếp danh sách tăng dần.");
                    break;
                case 6:
                    System.out.println("Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (luaChon != 6);

        scanner.close();
    }
}