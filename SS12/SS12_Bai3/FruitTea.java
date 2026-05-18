package SS12_Bai3;

public class FruitTea extends Drink implements IPromotion {

    public FruitTea(int id, String name, double price) {
        super(id, name, price);
    }

    @Override
    public void prepare() {
        System.out.println("Lắc với đá và trái cây tươi 🍹");
    }

    @Override
    public void applyDiscount(double percentage) {
        this.price = this.price * (1 - percentage / 100);
    }
}