package SS11_Bai3;

public class FullTimeEmployee extends Employee implements BonusEligible {
    private double baseSalary;

    public FullTimeEmployee(int id, String name, double baseSalary) {
        super(id, name);
        this.baseSalary = baseSalary;
    }

    @Override
    public double calculateSalary() {
        return this.baseSalary;
    }

    @Override
    public double calculateBonus() {
        return this.baseSalary * 0.10;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.printf("   - Lương cơ bản: %,.2f VNĐ\n", this.baseSalary);
        System.out.printf("   - Tiền thưởng (10%%): %,.2f VNĐ\n", this.calculateBonus());
        System.out.printf("   - Tổng thu nhập thực lĩnh: %,.2f VNĐ\n", (this.calculateSalary() + this.calculateBonus()));
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }
}