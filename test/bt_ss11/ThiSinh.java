package bt_ss11;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class ThiSinh {
    private String maTS;
    private String hoTen;
    private String gioiTinh;
    private String ngaySinhStr;
    private LocalDate ngaySinh;
    private String queQuan;

    public ThiSinh() {
    }

    public void input(Scanner sc, List<ThiSinh> listData) {
        String regexMaTS = "^(BK|SP|GT|XD|TC|CĐ|LA|Mo)[ABCDT]([1-9]|10)\\d{5}$";
        while (true) {
            System.out.print("Nhập mã thí sinh: ");
            this.maTS = sc.nextLine();
            if (this.maTS.matches(regexMaTS)) {
                break;
            }
            System.out.println(">>> LỖI: Mã TS sai định dạng! (Ví dụ: BKA100001, SPB500123...)");
        }

        while (true) {
            System.out.print("Nhập họ và tên: ");
            this.hoTen = sc.nextLine();
            if (this.hoTen.trim().length() >= 3) {
                break;
            }
            System.out.println(">>> LỖI: Họ tên phải có tối thiểu 3 kí tự!");
        }

        while (true) {
            System.out.print("Nhập giới tính (Nam/Nữ): ");
            this.gioiTinh = sc.nextLine();
            if (this.gioiTinh.equalsIgnoreCase("Nam") || this.gioiTinh.equalsIgnoreCase("Nữ")) {
                break;
            }
            System.out.println(">>> LỖI: Giới tính chỉ được nhập là 'Nam' hoặc 'Nữ'!");
        }

        while (true) {
            System.out.print("Nhập ngày sinh (dd/MM/yyyy): ");
            this.ngaySinhStr = sc.nextLine();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                this.ngaySinh = LocalDate.parse(this.ngaySinhStr, formatter);
                break;
            } catch (Exception e) {
                System.out.println(">>> LỖI: Ngày sinh sai định dạng dd/MM/yyyy! (Ví dụ: 30/05/2004)");
            }
        }

        while (true) {
            System.out.print("Nhập quê quán: ");
            this.queQuan = sc.nextLine();
            if (!this.queQuan.trim().isEmpty()) {
                break;
            }
            System.out.println(">>> LỖI: Quê quán không được để trống!");
        }
    }

    public void info() {
        System.out.format("| %-12s | %-20s | %-10s | %-12s | %-15s | Trường: %-15s |\n",
                maTS, hoTen, gioiTinh, ngaySinhStr, queQuan, getTenTruong());
    }

    public String getTenTruong() {
        if (maTS.startsWith("BK")) return "Bách khoa";
        if (maTS.startsWith("SP")) return "Sư phạm";
        if (maTS.startsWith("GT")) return "Giao thông";
        if (maTS.startsWith("XD")) return "Xây dựng";
        if (maTS.startsWith("TC")) return "Tài chính";
        if (maTS.startsWith("CĐ")) return "Công đoàn";
        if (maTS.startsWith("LA")) return "Luật";
        if (maTS.startsWith("Mo")) return "Mỏ địa chất";
        return "Chưa xác định";
    }

    public String getMaTruong() {
        return maTS.substring(0, 2);
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }
}