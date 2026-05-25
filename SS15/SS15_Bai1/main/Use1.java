package SS15_Bai1.main;

import SS15_Bai1.model.Movie;
import SS15_Bai1.service.MovieManager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Use1 {
    public static void main(String[] args) {
        MovieManager<Movie> manager = new MovieManager<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n======= HỆ THỐNG QUẢN LÝ PHIM =======");
                System.out.println("1. Thêm phim mới");
                System.out.println("2. Sửa thông tin phim");
                System.out.println("3. Xóa phim");
                System.out.println("4. Hiển thị danh sách phim");
                System.out.println("5. Tìm kiếm phim theo tên");
                System.out.println("6. Lọc phim có rating > 8.0");
                System.out.println("7. Thoát");
                System.out.print("Chọn chức năng (1-7): ");

                int choice;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.err.println("Lỗi: Vui lòng nhập vào một số nguyên từ 1 đến 7!");
                    continue;
                }

                if (choice == 7) {
                    System.out.println("Đã thoát chương trình.");
                    System.exit(0);
                }

                try {
                    switch (choice) {
                        case 1:
                            System.out.print("Nhập ID phim: ");
                            String id = scanner.nextLine();
                            System.out.print("Nhập tên phim: ");
                            String title = scanner.nextLine();
                            System.out.print("Nhập đạo diễn: ");
                            String director = scanner.nextLine();
                            System.out.print("Nhập ngày phát hành (yyyy-MM-dd): ");
                            LocalDate releaseDate = LocalDate.parse(scanner.nextLine(), formatter);
                            System.out.print("Nhập rating: ");
                            double rating = Double.parseDouble(scanner.nextLine());

                            manager.addMovie(new Movie(id, title, director, releaseDate, rating));
                            break;

                        case 2:
                            System.out.print("Nhập ID phim cần sửa: ");
                            String updateId = scanner.nextLine();
                            System.out.print("Nhập tên phim mới: ");
                            String newTitle = scanner.nextLine();
                            System.out.print("Nhập đạo diễn mới: ");
                            String newDirector = scanner.nextLine();
                            System.out.print("Nhập ngày phát hành mới (yyyy-MM-dd): ");
                            LocalDate newReleaseDate = LocalDate.parse(scanner.nextLine(), formatter);
                            System.out.print("Nhập rating mới: ");
                            double newRating = Double.parseDouble(scanner.nextLine());

                            if (manager.updateMovie(updateId, newTitle, newDirector, newReleaseDate, newRating)) {
                                System.out.println("Cập nhật thông tin phim thành công!");
                            } else {
                                System.out.println("Không tìm thấy phim có ID: " + updateId);
                            }
                            break;

                        case 3:
                            System.out.print("Nhập ID phim cần xóa: ");
                            String deleteId = scanner.nextLine();
                            if (manager.deleteMovie(deleteId)) {
                                System.out.println("Xóa phim thành công!");
                            } else {
                                System.out.println("Không tìm thấy phim có ID: " + deleteId);
                            }
                            break;

                        case 4:
                            System.out.println("\n--- DANH SÁCH PHIM ---");
                            manager.displayAll();
                            break;

                        case 5:
                            System.out.print("Nhập tên phim cần tìm: ");
                            String searchTitle = scanner.nextLine();
                            manager.searchByTitle(searchTitle);
                            break;

                        case 6:
                            System.out.println("\n--- CÁC PHIM CÓ RATING > 8.0 ---");
                            manager.filterHighRating();
                            break;

                        default:
                            System.out.println("Chức năng không hợp lệ, vui lòng chọn lại từ 1 đến 7.");
                    }
                } catch (DateTimeParseException e) {
                    System.err.println("Lỗi định dạng ngày! Vui lòng nhập đúng mẫu yyyy-MM-dd (Ví dụ: 2026-05-25).");
                } catch (NumberFormatException e) {
                    System.err.println("Lỗi dữ liệu số! Đánh giá (rating) phải là một số (Ví dụ: 8.5).");
                }
            }
        }
    }
}