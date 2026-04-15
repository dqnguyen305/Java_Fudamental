import java.util.Scanner;

public class XuatSac2 {
    public static void main(String[] args) {
        double vt, tg;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập vận tốc (km/h): ");
        vt = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập thời gian đi (giờ): ");
        tg = Double.parseDouble(sc.nextLine());

        double qd = vt*tg;
        System.out.printf("Quãng đường: %.2f", qd);
    }
}
