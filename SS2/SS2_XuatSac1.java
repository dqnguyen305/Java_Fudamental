import java.util.Scanner;

public class SS2_XuatSac1 {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập n: ");
        n = Integer.parseInt(sc.nextLine());
        if (n<100 || n>999){
            System.out.println("Số nhập vào không hợp lệ");
            return;
        }
        int hundreds, tens, units;
        units = n%10;
        tens = (n/10)%10;
        hundreds = n/100;
        docSo(hundreds);
        System.out.print(" trăm");
        if (tens > 1) {
            docSo(tens);
            System.out.print(" mươi");
        } else if (tens ==1){
            System.out.print(" mười");
        } else if (tens == 0 && units != 0) {
            System.out.print(" lẻ");
        }

        if (units == 5 && tens >= 1) {
            System.out.print(" lăm");
        } else if (units != 0) {
            docSo(units);
        }



    }
    public static void docSo (int so) {
        switch (so) {
            case 1: System.out.print(" một"); break;
            case 2: System.out.print(" hai"); break;
            case 3: System.out.print(" ba"); break;
            case 4: System.out.print(" bốn"); break;
            case 5: System.out.print(" năm"); break;
            case 6: System.out.print(" sáu"); break;
            case 7: System.out.print(" bảy"); break;
            case 8: System.out.print(" tám"); break;
            case 9: System.out.print(" chín"); break;
        }
    }
}

