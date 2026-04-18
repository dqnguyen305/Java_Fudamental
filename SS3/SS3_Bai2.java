import java.util.Scanner;

public class SS3_Bai2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int soHocVien = 0;
        double tongDiem = 0, diemCaoNhat = -1, diemThapNhat = 11;

        while (true){
            System.out.println("********** MENU NHẬP ĐIỂM ***********");
            System.out.println("1. Nhập điểm học viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int n = Integer.parseInt(sc.nextLine());

            switch (n){
                case 1:
                    System.out.println("-------- Nhập điểm học viên (Nhập -1 để dừng)---------------- ");
                    do {
                        System.out.print("Nhập điểm: ");
                        double d = Double.parseDouble(sc.nextLine());
                        if (d == -1 ) break;
                        if (d < 0 || d > 10) {
                            System.out.println("Điểm không hợp lệ. Nhập lại.");
                            continue;
                        }
                        soHocVien++;
                        String hl;
                        if (d < 5){
                            hl = "Yếu";
                        } else if (d < 7) {
                            hl = "Trung bình";
                        } else if (d < 8) {
                            hl = "Khá";
                        } else if (d < 9) {
                            hl = "Giỏi";
                        } else {
                            hl = "Xuất sắc";
                        }
                        System.out.println("Học lực: " + hl);
                        tongDiem +=d;
                        if (d > diemCaoNhat) {
                            diemCaoNhat = d;
                        }
                        if (d < diemThapNhat) {
                            diemThapNhat = d;
                        }
                    } while (true);
                    break;
                case 2:
                    if(soHocVien == 0){
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        double diemTB =  tongDiem/soHocVien;
                        System.out.println("--- KẾT QUẢ ---");
                        System.out.println("Số học viên đã nhập: "+ soHocVien);
                        System.out.println("Điểm trung bình: " + diemTB);
                        System.out.println("Điểm cao nhất: " + diemCaoNhat);
                        System.out.println("Điểm thấp nhất: " + diemThapNhat);
                    }
                    break;

                case 3:
                    System.out.println("Kết thúc chương trình");
                    System.exit(0);
                    break;

            }
        }


    }
}
