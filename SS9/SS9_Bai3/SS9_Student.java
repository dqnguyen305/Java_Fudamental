public class SS9_Student {
    private String id;
    private String fullName;
    private int age;
    private double gpa;

    private static int count = 0;

    public static final double MIN_GPA = 0.0;
    public static final double MAX_GPA = 4.0;

    public SS9_Student(String id, String fullName, int age, double gpa) {
        this.id = id;
        this.fullName = fullName;
        this.age = age;

        if (gpa >= MIN_GPA && gpa <= MAX_GPA) {
            this.gpa = gpa;
        } else {
            this.gpa = 0.0;
            System.out.println("Cảnh báo: GPA không hợp lệ cho sinh viên " + fullName);
        }

        count++;
    }

    public static int getCount() {
        return count;
    }

    public void printInfo() {
        System.out.printf("ID: %s | Tên: %-15s | Tuổi: %d | GPA: %.1f%n",
                id, fullName, age, gpa);
    }
}
