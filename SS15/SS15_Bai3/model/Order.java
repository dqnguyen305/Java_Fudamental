package SS15_Bai3.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private int orderId;
    private final List<Product> products = new ArrayList<>();

    public Order(int orderId) {
        this.orderId = orderId;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double getTotalPrice() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    @Override
    public String toString() {
        return "Mã Đơn Hàng: " + orderId + " | Số sản phẩm: " + products.size() + " | Tổng tiền: " + getTotalPrice() + " VNĐ";
    }
}