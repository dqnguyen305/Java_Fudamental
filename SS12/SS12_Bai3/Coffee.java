package SS12_Bai3;

public class Coffee extends Drink implements IPromotion {

    public Coffee(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void prepare() {
        System.out.println("Pha bằng máy ☕");
    }

    @Override
    public void applyDiscount(double percentage) {
        this.price = this.price * (1 - percentage / 100);
    }
}