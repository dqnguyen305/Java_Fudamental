package SS12_Bai1;

public class Lecturer extends Staff implements ICapability {
    private int teachingHours;

    public Lecturer(int id, String name, double baseSalary, int teachingHours) {
        super(id, name, baseSalary);
        this.teachingHours = teachingHours;
    }

    public void setTeachingHours(int teachingHours) {
        this.teachingHours = teachingHours;
    }

    @Override
    public double calculateTotalSalary() {
        return baseSalary + (teachingHours * 200000);
    }

    @Override
    public void checkPerformance() {
        if (teachingHours >= 50) {
            System.out.println("Đánh giá: Giảng viên xuất sắc (Giờ dạy cao)");
        } else {
            System.out.println("Đánh giá: Giảng viên hoàn thành nhiệm vụ");
        }
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.printf(" | Giờ dạy: %d | Tổng lương: %,.0f VNĐ\n", teachingHours, calculateTotalSalary());
        checkPerformance();
    }
}