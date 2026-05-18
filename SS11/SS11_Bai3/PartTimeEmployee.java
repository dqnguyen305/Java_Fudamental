package SS11_Bai3;

public class PartTimeEmployee extends Employee {
    private int hourlyRate;
    private int hoursWorked;

    public PartTimeEmployee(int id, String name, int hourlyRate, int hoursWorked) {
        super(id, name);
        this.hourlyRate = hourlyRate;
        this.hoursWorked = hoursWorked;
    }

    @Override
    public double calculateSalary() {
        return this.hourlyRate * this.hoursWorked;
    }

    @Override
    public void showInfo() {
        super.showInfo();
        System.out.printf("   - Lương theo giờ: %,d VNĐ/h\n", this.hourlyRate);
        System.out.printf("   - Số giờ làm việc: %d giờ\n", this.hoursWorked);
        System.out.printf("   - Tổng lương nhận: %,.2f VNĐ\n", this.calculateSalary());
    }

    public int getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(int hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public int getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(int hoursWorked) {
        this.hoursWorked = hoursWorked;
    }
}