package SS12_Bai1;

public abstract class Staff {
    protected int id;
    protected String name;
    protected double baseSalary;

    public Staff(int id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public abstract double calculateTotalSalary();

    public void showInfo() {
        System.out.printf("ID: %d | Tên: %s | Lương cơ bản: %,.0f VNĐ", id, name, baseSalary);
    }
}