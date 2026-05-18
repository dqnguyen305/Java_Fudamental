package SS12_Bai1;

public class AdminStaff extends Staff implements ICapability {
    private double bonus;

    public AdminStaff(int id, String name, double baseSalary, double bonus) {
        super(id, name, baseSalary);
        this.bonus = bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public double calculateTotalSalary() {
        return baseSalary + bonus;
    }

    @Override
    public void checkPerformance() {
        if (bonus > 2000000) {
            System.out.println("Đánh giá: Nhân viên tích cực (Thưởng cao)");
        } else {
            System.out.println("Đánh giá: Nhân viên hoàn thành tốt công việc");
        }
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.printf(" | Thưởng: %,.0f VNĐ | Tổng lương: %,.0f VNĐ\n", bonus, calculateTotalSalary());
        checkPerformance();
    }
}