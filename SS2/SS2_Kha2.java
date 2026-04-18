import java.util.Scanner;

public class SS2_Kha2 {
    public static void main(String[] args) {
        int m;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Nhập m: ");
            m = Integer.parseInt(sc.nextLine());
            if(m<1 || m >12) {
                System.out.println("Tháng không hợp lệ.");
            }
        } while (m<1 || m>12);
        switch (m) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                System.out.println("Tháng " + m + " có 31 ngày");
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                System.out.println("Tháng " + m + " có 30 ngày");
                break;
            default:
                System.out.println("Tháng " + m + " có 28 hoặc 29 ngày");
        }
    }
}
