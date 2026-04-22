import java.util.Scanner;

public class SS4_Gioi2 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số phần tử của mảng : ");
        n = Integer.parseInt(sc.nextLine());

        if (n <=0) {
            System.out.println("Mảng không có phần tử");
            return;
        }
        int[] arr = new int[n];
        System.out.println("Nhập các phần tử của mảng: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Phần tử thứ " + (i + 1) + ": ");
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        int c = 0, l = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] % 2 == 0) {
                arr1[c++] = arr[i];
            } else {
                arr2[l++] = arr[i];
            }
        }
        int[] arr3 = new int[n];
        int index = 0;
        for (int i = 0; i < c; i++) {
            arr3[index++] = arr1[i];
        }
        for (int i = 0; i < l; i++) {
            arr3[index++] = arr2[i];
        }
        System.out.println("Mảng sau khi sắp xếp: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr3[i] + " ");
        }
    }
}
