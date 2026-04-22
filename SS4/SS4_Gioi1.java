import java.util.Scanner;

public class SS4_Gioi1 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhập số lượng phần tử của mảng: ");
        n = Integer.parseInt(sc.nextLine());

        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của mảng: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            arr[i] = Integer.parseInt(sc.nextLine());
        }

        int min;
        for (int i = 0; i < n - 1; i++) {
            min = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] > arr[min]) {
                    min = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
        System.out.println("Mảng sau khi sắp xếp giảm dần: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        int a;
        System.out.print("\nNhập phần tử cần tìm: ");
        a = sc.nextInt();

        for (int i = 0; i < n; i++) {
            if (arr[i] == a) {
                System.out.print("Tìm kiếm tuyến tính: Số "+ a + " có tại vị trí "+i);
            }
        }
        int left = 0;
        int right =  arr.length -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == a) {
                System.out.print("\nTìm kiếm nhị phân: Số "+ a + " có tại vị trí "+mid);
                break;
            } else if (arr[mid] < a) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
    }
}
