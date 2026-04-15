import java.util.Scanner;

public class XuatSac1 {
    public static void main(String[] args) {
        double cn, cc;
        Scanner sc = new Scanner(System.in);

        System.out.println("Nhập cân nặng: ");
        cn = Double.parseDouble(sc.nextLine());

        System.out.println("Nhập chiều cao: ");
        cc = Double.parseDouble(sc.nextLine());

        double bmi = cn / Math.pow(cc,2);
        System.out.printf("BMI : %.2f", bmi);
    }
}
