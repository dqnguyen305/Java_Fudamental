package SS11_Bai3;

import java.util.ArrayList;
import java.util.List;

public class Use3 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();

        employees.add(new FullTimeEmployee(1, "Nguyễn Văn A", 15000000));
        employees.add(new FullTimeEmployee(2, "Trần Thị B", 25000000));

        System.out.println("=== THÔNG TIN CHI TIẾT NHÂN VIÊN ===");
        for (Employee emp : employees) {
            emp.showInfo();
            System.out.println("----------------------------------------");
        }

        System.out.println("\n=== BẢNG THỐNG KÊ CHI TRẢ LƯƠNG & THƯỞNG ===");
        double totalCompanyExpense = 0;

        for (Employee emp : employees) {
            double salary = emp.calculateSalary();
            double bonus = 0;

            if (emp instanceof BonusEligible) {
                bonus = ((BonusEligible) emp).calculateBonus();
            }

            double totalPayout = salary + bonus;
            totalCompanyExpense += totalPayout;

            emp.showInfo();
            System.out.printf("   => Thực nhận: %,.2f VNĐ (Lương: %,.2f | Thưởng: %,.2f)\n", totalPayout, salary, bonus);
            System.out.println("----------------------------------------");
        }

        System.out.println("============================================");
        System.out.printf("📊 TỔNG CHI PHÍ DOANH NGHIỆP CHI TRẢ: %,.2f VNĐ\n", totalCompanyExpense);
    }
}