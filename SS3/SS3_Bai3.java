import java.text.DecimalFormat;
import java.util.Scanner;

public class SS3_Bai3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("# ,###");
        int soNhanVien = 0;
        int tongLuong = 0, luongCaoNhat = -1, luongThapNhat = 1000000000;
        double tongThuong = 0;
        while (true){
            System.out.println("**************** MENU NHẬP LƯƠNG *************");
            System.out.println("1. Nhập lương nhân viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Tính tống số tiền thưởng cho nhân viên");
            System.out.println("4. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int n = Integer.parseInt(sc.nextLine());
            switch (n){
                case 1:
                    System.out.println("************ MENU NHẬP LƯƠNG ************** ");
                    do {
                        System.out.print("Nhập lương: ");
                        long l = Long.parseLong(sc.nextLine());
                        if (l == -1 ) break;
                        if (l < 0 || l > 500000000) {
                            System.out.println("Lương không hợp lệ. Nhập lại.");
                            continue;
                        }
                        if (l < 5000000) {
                            tongThuong += l * 0.05;
                        } else if (l < 15000000) {
                            tongThuong += l * 0.1;
                        } else if (l < 50000000) {
                            tongThuong += l * 0.15;
                        } else if (l < 100000000) {
                            tongThuong += l * 0.2;
                        } else {
                            tongThuong += l * 0.25;
                        }
                        soNhanVien++;
                        tongLuong +=l;
                        if (l > luongCaoNhat) {
                            luongCaoNhat = (int) l;
                        }
                        if (l < luongThapNhat) {
                            luongThapNhat = (int) l;
                        }
                        if (l < 5000000) {
                            System.out.println("Thu nhập thấp");
                        } else if (l < 15000000) {
                            System.out.println("Thu nhập trung bình");
                        } else if (l < 50000000) {
                            System.out.println("Thu nhập khá");
                        } else {
                            System.out.println("Thu nhập cao");
                        }
                    } while (true);
                    break;
                case 2:
                    if(soNhanVien == 0){
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        double luongTB =  tongLuong/soNhanVien;
                        System.out.println("--- KẾT QUẢ ---");
                        System.out.println("Số nhân viên đã nhập: "+ soNhanVien);
                        System.out.println("Lương trung bình: " + df.format(luongTB));
                        System.out.println("Lương cao nhất: " + df.format(luongCaoNhat));
                        System.out.println("Lương thấp nhất: " + df.format(luongThapNhat));
                        System.out.println("Tổng tiền lương: " + df.format(tongLuong));
                    }
                    break;
                case 3:
                    if (soNhanVien == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {


                        System.out.println("Tổng tiền thưởng nhân viên: " + df.format(tongThuong));
                    }
                    break;
                case 4:
                    System.out.println("Thoát chương trình");
                    System.exit(0);
                    break;
            }
        }


    }
}
