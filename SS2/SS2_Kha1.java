import java.util.Scanner;

public class SS2_Kha1 {
    public static void main(String[] args) {
        int n;
        int sum = 0;
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập n: ");
        n = Integer.parseInt(sc.nextLine());

        if(n < 0) {
            return;
        }

        for(int i = 1;i<=n; i++){
            sum += i;
        }
        System.out.printf("Tổng từ 1 đến %d là: %d", n, sum);
    }
}
