import java.util.Arrays;
import java.util.Scanner;

public class SS4_XuatSac2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 1. Nhập số lượng và lương nhân viên
        System.out.print("Nhập số lượng nhân viên: ");
        int n = Integer.parseInt(sc.nextLine());
        double[] salaries = new double[n];

        int c = 0;

        for (int i = 0; i < n; i++) {
            System.out.print("Nhập lương nhân viên " + (i + 1) + ": ");
            salaries[i] = Double.parseDouble(sc.nextLine());
        }

        int choice = 0;
        do {
            System.out.println("\n--- QUẢN LÝ LƯƠNG NHÂN VIÊN ---");
            System.out.println("1. Xem danh sách lương");
            System.out.println("2. Sắp xếp lương");
            System.out.println("3. Tìm kiếm lương");
            System.out.println("4. Thống kê lương");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    System.out.println("Danh sách lương nhân viên: ");
                    for (int i = 0; i < n; i++) {
                        System.out.printf("Nhân viên %d: %.2f\n", (i + 1), salaries[i]);
                    }
                    break;

                case 2:
                    System.out.println("Chọn cách sắp xếp: ");
                    System.out.println("1. Tăng dần");
                    System.out.println("2. Giảm dần");
                    c = Integer.parseInt(sc.nextLine());


                    for (int i = 0; i < n - 1; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (c == 1) {
                                if (salaries[i] > salaries[j]) {
                                    double temp = salaries[i];
                                    salaries[i] = salaries[j];
                                    salaries[j] = temp;
                                }
                            } else if (c == 2) {
                                if (salaries[i] < salaries[j]) {
                                    double temp = salaries[i];
                                    salaries[i] = salaries[j];
                                    salaries[j] = temp;
                                }
                            }
                        }
                    }
                    System.out.println(c == 1 ? "Đã sắp xếp tăng dần." : "Đã sắp xếp giảm dần.");
                    break;

                case 3:
                    System.out.print("Nhập mức lương cần tìm: ");
                    double target = Double.parseDouble(sc.nextLine());
                    boolean found = false;

                    for (int i = 0; i < n; i++) {
                        if (salaries[i] == target) {
                            System.out.println("Tuyến tính: Tìm thấy tại vị trí (index) " + i);
                            found = true;
                            break;
                        }
                    }

                    if (c == 0) {
                        System.out.println("Mảng chưa sắp xếp, không thể tìm nhị phân.");
                    } else {
                        int left = 0, right = n - 1;
                        while (left <= right) {
                            int mid = left + (right - left) / 2;
                            if (salaries[mid] == target) {
                                System.out.println("Nhị phân: Tìm thấy tại vị trí (index) " + mid);
                                found = true;
                                break;
                            }
                            if (c == 1) { // Mảng tăng dần
                                if (salaries[mid] < target) left = mid + 1;
                                else right = mid - 1;
                            } else { // Mảng giảm dần
                                if (salaries[mid] > target) left = mid + 1;
                                else right = mid - 1;
                            }
                        }
                    }
                    if (!found) System.out.println("Không tìm thấy mức lương " + target);
                    break;

                case 4:
                    double tong = 0;
                    for (double s : salaries) tong += s;
                    double trungBinh = tong / n;

                    double max = salaries[0];
                    double min = salaries[0];
                    int demTrenTB = 0;

                    for (double s : salaries) {
                        if (s > max) max = s;
                        if (s < min) min = s;
                        if (s > trungBinh) demTrenTB++;
                    }

                    System.out.printf("Tổng lương: %.2f\n", tong);
                    System.out.printf("Lương trung bình: %.2f\n", trungBinh);
                    System.out.printf("Lương cao nhất: %.2f\n", max);
                    System.out.printf("Lương thấp nhất: %.2f\n", min);
                    System.out.println("Số nhân viên có lương trên trung bình: " + demTrenTB);
                    break;

                case 5:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        } while (choice != 5);

        sc.close();
    }
}