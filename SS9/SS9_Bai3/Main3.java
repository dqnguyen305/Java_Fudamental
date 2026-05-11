public class Main3 {
    public static void main(String[] args) {

        SS9_Student s1 = new SS9_Student("S01", "Nguyễn Văn Anh", 20, 3.8);
        SS9_Student s2 = new SS9_Student("S02", "Trần Thị Bình", 21, 3.2);
        SS9_Student s3 = new SS9_Student("S03", "Lê Minh Công", 19, 4.5);

        System.out.println("\n--- DANH SÁCH SINH VIÊN ---");
        s1.printInfo();
        s2.printInfo();
        s3.printInfo();

        System.out.println("---------------------------");
        System.out.println("Tổng số sinh viên hiện có: " + SS9_Student.getCount());
    }
}