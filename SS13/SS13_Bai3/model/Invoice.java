package SS13_Bai3.model;

public class Invoice {
    private String id;
    private double amount;

    public Invoice(String id, double amount) {
        this.id = id;
        this.amount = amount;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Mã hóa đơn: " + id + " | Số tiền: " + amount;
    }
}