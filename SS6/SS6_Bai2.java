import java.util.Scanner;

public class SS6_Bai2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String hoTen = "", email = "", sdt = "", matKhau = "";
        int luaChon;

        do {
            System.out.println("\n******************** QUẢN LÝ NGƯỜI DÙNG ********************");
            System.out.println("1. Nhập thông tin người dùng");
            System.out.println("2. Chuẩn hóa họ tên");
            System.out.println("3. Kiểm tra email hợp lệ");
            System.out.println("4. Kiểm tra số điện thoại hợp lệ");
            System.out.println("5. Kiểm tra mật khẩu hợp lệ");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            luaChon = scanner.nextInt();
            scanner.nextLine();

            switch (luaChon) {
                case 1:
                    System.out.print("Nhập họ và tên: ");
                    hoTen = scanner.nextLine();
                    System.out.print("Nhập email: ");
                    email = scanner.nextLine();
                    System.out.print("Nhập số điện thoại: ");
                    sdt = scanner.nextLine();
                    System.out.print("Nhập mật khẩu: ");
                    matKhau = scanner.nextLine();
                    break;
                case 2:
                    if (hoTen.isEmpty()) {
                        System.out.println("Chưa nhập họ tên!");
                    } else {
                        hoTen = hoTen.trim().toLowerCase().replaceAll("\\s+", " ");
                        String[] words = hoTen.split(" ");
                        StringBuilder sb = new StringBuilder();
                        for (String w : words) {
                            sb.append(Character.toUpperCase(w.charAt(0))).append(w.substring(1)).append(" ");
                        }
                        hoTen = sb.toString().trim();
                        System.out.println("Họ tên sau chuẩn hóa: " + hoTen);
                    }
                    break;
                case 3:
                    String emailRegex = "^[a-zA-Z0-9._]+@[a-zA-Z0-9.]+\\.[a-zA-Z]{2,6}$";
                    if (email.matches(emailRegex)) {
                        System.out.println("Email hợp lệ");
                    } else {
                        System.out.println("Email không hợp lệ");
                    }
                    break;
                case 4:
                    String sdtRegex = "^(0|\\+84)(\\s|\\.)?((3[2-9])|(5[689])|(7[06-9])|(8[1-689])|(9[0-46-9]))(\\d)(\\s|\\.)?(\\d{3})(\\s|\\.)?(\\d{3})$";
                    if (sdt.replace(" ", "").matches("^(0|\\+84)[35789]\\d{8}$")) {
                        System.out.println("Số điện thoại hợp lệ");
                    } else {
                        System.out.println("Số điện thoại không hợp lệ");
                    }
                    break;
                case 5:
                    String mkRegex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%!^&*()]).{8,}$";
                    if (matKhau.matches(mkRegex)) {
                        System.out.println("Mật khẩu hợp lệ");
                    } else {
                        System.out.println("Mật khẩu không hợp lệ");
                    }
                    break;
                case 6:
                    System.out.println("Tạm biệt!");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while (luaChon != 6);

        scanner.close();
    }
}