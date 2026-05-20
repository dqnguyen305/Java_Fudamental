package SS13_Bai4.business;

import SS13_Bai4.model.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderManager implements Manage<Order> {
    private final List<Order> orderList = new ArrayList<>();

    @Override
    public void add(Order order) {
        orderList.add(order);
    }

    @Override
    public void update(int index, Order order) {
        if (index >= 0 && index < orderList.size()) {
            orderList.set(index, order);
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Vị trí cập nhật không hợp lệ!");
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < orderList.size()) {
            orderList.remove(index);
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Vị trí xóa không hợp lệ!");
        }
    }

    @Override
    public void display() {
        if (orderList.isEmpty()) {
            System.out.println("Không có đơn hàng nào.");
        } else {
            for (Order order : orderList) {
                System.out.println(order);
            }
        }
    }

    public int findIndexByID(String id) {
        for (int i = 0; i < orderList.size(); i++) {
            if (orderList.get(i).getOrderId().equalsIgnoreCase(id.trim())) {
                return i;
            }
        }
        return -1;
    }
}