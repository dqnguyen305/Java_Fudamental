import java.util.Scanner;

public class SS2_XuatSac2 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Nhập n: ");
            n = Integer.parseInt(sc.nextLine());
            if (n <= 0) {
                System.out.println("Số nhập vào không hợp lệ");
            }
        } while (n <= 0);
        for (int i =0; i<=n; i++){
            if (kiemTra(i)) {
               System.out.print(i + " ");
            }
        }

    }
    public static boolean kiemTra(int n){
        int sum = 0, k = 0;
        int temp = n;
        while (temp >0){
            k++;
            temp = temp/10;
        }
        temp = n;
        while (temp > 0) {
            int m = temp%10;
            sum += Math.pow(m, k);
            temp = temp/10;
        }
        if (sum == n) {
            return true;
        } else {
            return false;
        }
    }
}
