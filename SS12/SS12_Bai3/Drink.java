package SS12_Bai3;

public abstract class Drink {
    protected int id;
    protected String name;
    protected double price;

    public Drink(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract void prepare();

    public void showInfo() {
        System.out.printf("Mã món: %d | Tên: %s | Giá: %,.0f VNĐ | Cách pha: ", id, name, price);
        prepare();
    }
}