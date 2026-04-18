import java.util.Scanner;

public class SS3_Bai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String tenKH, tenSp;
        double gia;
        int sl;
        boolean theTV;
        System.out.println("========= NHẬP THÔNG TIN HÓA ĐƠN =======");
        System.out.print("Nhập tên khách hàng: ");
        tenKH = sc.nextLine();
        System.out.print("Nhập tên sản phẩm: ");
        tenSp = sc.nextLine();
        System.out.print("Nhập giá sản phẩm: ");
        gia = Double.parseDouble(sc.nextLine());
        System.out.print("Nhập số lượng mua: ");
        sl = Integer.parseInt(sc.nextLine());
        System.out.print("Khách hàng có thẻ thành viên (true/false): ");
        theTV = Boolean.parseBoolean(sc.nextLine());
        double tt = gia * sl;
        double giamGia = 0;
        if (theTV) {
            giamGia = tt * 0.1;
        }
        double VAT = tt*0.08;
        double tong = tt-giamGia + VAT;
        System.out.println("========= HÓA ĐƠN =======");
        System.out.println("Khách hàng: " + tenKH);
        System.out.println("Sản phẩm: " + tenSp);
        System.out.println("Số lượng: " + sl);
        System.out.println("Đơn giá: " + gia);
        System.out.println("Thành tiền: " + tt);
        System.out.println("Giảm giá thành viên (10%): " + giamGia);
        System.out.println("VAT (8%): " + VAT);
        System.out.println("Tổng cộng thanh toán: " + tong);
    }
}
