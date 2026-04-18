import java.util.Scanner;

public class SS2_Gioi1 {
    public static void main(String[] args) {
        int n;
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập n: ");
        n = Math.abs(Integer.parseInt(sc.nextLine()));
        while (n>0){
            sum += n %10;
            n /= 10;
        }
        System.out.println("Tổng các chữ số là: " + sum);
    }
}
