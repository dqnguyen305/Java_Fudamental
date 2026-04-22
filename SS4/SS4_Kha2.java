import java.util.Scanner;

public class SS4_Kha2 {
    public static void main(String[] args) {
        int m,n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số hàng của mảng : ");
        m = Integer.parseInt(sc.nextLine());
        System.out.print("Nhập số cột của mảng : ");
        n = Integer.parseInt(sc.nextLine());

        int[][] arr = new int[m][n];

        System.out.println("Nhập các phần tử của mảng: ");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("Phần tử thứ [" + i + "][" + j + "]: ");
                arr[i][j] = Integer.parseInt(sc.nextLine());
            }
        }
        int tongC = 0, tongL = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (arr[i][j] %2 == 0){
                    tongC += arr[i][j];
                } else {
                    tongL += arr[i][j];
                }
            }
        }
        System.out.println("Tổng các số chẵn: " + tongC);
        System.out.println("Tổng các số lẻ: " + tongL);
    }
}
