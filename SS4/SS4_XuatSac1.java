import java.util.Arrays;
import java.util.Scanner;

public class SS4_XuatSac1 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số lượng sinh viên: ");
        n = Integer.parseInt(sc.nextLine());
        int c = 0;
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Nhập điểm của sinh viên thứ " + (i+1) + ": ");
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        int a = 0;
        do {
            System.out.println("--- QUẢN LÝ ĐIỂM SINH VIÊN ---");
            System.out.println("1. Xem tất cả điểm");
            System.out.println("2. Sắp xếp điểm");
            System.out.println("3. Tìm kiếm điểm");
            System.out.println("4. Thống kê điểm");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            a = Integer.parseInt(sc.nextLine());
            switch (a) {
                case 1:
                    System.out.println("Điểm của tất cả sinh viên: ");
                    for (int i = 0; i < n; i++) {
                        System.out.println("Sinh viên " + (i+1) + ": " + arr[i]);
                    }
                    break;
                case 2:
                    System.out.println("Chọn cách sắp xếp: ");
                    System.out.println("1. Tăng dần");
                    System.out.println("2. Giảm dần");

                    c = Integer.parseInt(sc.nextLine());
                    if (c == 1) {
                        for (int i = 0; i < n - 1; i++) {
                            for (int j = i + 1; j < n; j++) {
                                if (arr[i] > arr[j]) {
                                    int temp = arr[i];
                                    arr[i] = arr[j];
                                    arr[j] = temp;
                                }
                            }
                        }
                        System.out.println("Đã sắp xếp tăng dần");
                    }
                    if (c == 2) {
                        for (int i = 0; i < n - 1; i++) {
                            for (int j = i + 1; j < n; j++) {
                                if (arr[i] < arr[j]) {
                                    int temp = arr[i];
                                    arr[i] = arr[j];
                                    arr[j] = temp;
                                }
                            }
                        }
                        System.out.println("Đã sắp xếp giảm dần");
                    }
                    break;
                case 3:
                    System.out.print("Nhập điểm cần tìm: ");
                    int diemCanTim = Integer.parseInt(sc.nextLine());
                    boolean found = false;
                    for (int i = 0; i < n; i++) {
                        if (arr[i] == diemCanTim) {
                            System.out.println("Tìm kiếm tuyến tính: Tìm thấy tại vị trí " + i);
                            found = true;
                            break;
                        }
                    }
                    if(c == 0){
                        System.out.println("Mảng chưa được sắp xếp  nên không thể tìm kiếm nhị phân");
                    } else if (c == 1) {
                        int left = 0;
                        int right = arr.length - 1;
                        while (left <= right) {
                            int mid = left + (right - left) / 2;
                            if (arr[mid] == diemCanTim) {
                                System.out.println("Tìm kiếm nhị phân: Tìm thấy tại vị trí " + (mid));
                                found = true;
                                break;
                            } else if (arr[mid] < diemCanTim) {
                                left = mid + 1;
                            } else {
                                right = mid - 1;
                            }
                        }
                    } else if (c == 2) {
                        int left = 0;
                        int right = arr.length - 1;
                        while (left <= right) {
                            int mid = left + (right - left) / 2;
                            if (arr[mid] == diemCanTim) {
                                System.out.println("Tìm kiếm nhị phân: Tìm thấy tại vị trí " + (mid + 1));
                                found = true;
                                break;
                            } else if (arr[mid] > diemCanTim) {
                                left = mid + 1;
                            } else {
                                right = mid - 1;
                            }
                        }

                    }
                    if (!found) {
                        System.out.println("Không tìm thấy điểm " + diemCanTim);
                    }
                    break;
                case 4:
                    int tongDiem = 0;
                    for (int i = 0; i < n; i++) {
                        tongDiem += arr[i];
                    }
                    double trungBinh = (double) tongDiem / n;
                    int max = Arrays.stream(arr).max().getAsInt();
                    int min = Arrays.stream(arr).min().getAsInt();
                    int dem = 0;
                    System.out.println("Điểm trung bình: " + trungBinh);
                    System.out.println("Điểm cao nhất: " + max);
                    System.out.println("Điểm thấp nhất: " + min);
                    for (int i = 0; i < n; i++) {
                        if (arr[i] >= trungBinh) {
                            dem++;
                        }
                    }
                    System.out.println("Số sinh viên có điểm trên trung bình: " + dem);
                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
            }
        }while (a != 5);
    }
}
