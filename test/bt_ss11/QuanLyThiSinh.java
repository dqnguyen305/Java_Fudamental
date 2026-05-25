package bt_ss11;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class QuanLyThiSinh {
    public static void main(String[] args) {
        List<ThiSinh> listData = new ArrayList<>();
        int n;
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Nhập vào số thí sinh: ");
            try {
                n = Integer.parseInt(sc.nextLine());
                if (n < 1) {
                    System.out.println("Phải nhập số thí sinh >0");
                } else {
                    break;
                }
            } catch (Exception e) {
                System.out.println("Số thí sinh phải nhập là số");
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println("Nhập thông tin thí sinh thứ " + (i + 1));
            ThiSinh data = new ThiSinh();
            data.input(sc, listData);
            listData.add(data);
        }

        System.out.println("\n================ THÔNG TIN CÁC THÍ SINH ĐÃ ĐĂNG KÝ ================");
        for (ThiSinh dt : listData) {
            dt.info();
        }

        System.out.println("\n================ DANH SÁCH THÍ SINH THEO TỪNG TRƯỜNG ================");
        String[] cacMaTruong = {"BK", "SP", "GT", "XD", "TC", "CĐ", "LA", "Mo"};
        String[] cacTenTruong = {"Bách khoa", "Sư phạm", "Giao thông", "Xây dựng", "Tài chính", "Công đoàn", "Luật", "Mỏ địa chất"};

        for (int i = 0; i < cacMaTruong.length; i++) {
            String maTruong = cacMaTruong[i];
            System.out.println("\n--> Trường: " + cacTenTruong[i] + " (" + maTruong + ")");
            boolean coThiSinh = false;
            for (ThiSinh dt : listData) {
                if (dt.getMaTruong().equals(maTruong)) {
                    dt.info();
                    coThiSinh = true;
                }
            }
            if (!coThiSinh) {
                System.out.println("   (Không có thí sinh nào đăng ký vào trường này)");
            }
        }

        Collections.sort(listData, new Comparator<ThiSinh>() {
            @Override
            public int compare(ThiSinh ts1, ThiSinh ts2) {
                return ts2.getNgaySinh().compareTo(ts1.getNgaySinh());
            }
        });

        System.out.println("\n================ DANH SÁCH SẮP XẾP GIẢM DẦN THEO NGÀY SINH ================");
        for (ThiSinh dt : listData) {
            dt.info();
        }
    }
}