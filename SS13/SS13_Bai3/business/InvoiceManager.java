package SS13_Bai3.business;

import SS13_Bai3.model.Invoice;
import java.util.ArrayList;
import java.util.List;

public class InvoiceManager implements Manage<Invoice> {
    private final List<Invoice> invoiceList = new ArrayList<>();

    @Override
    public void add(Invoice item) {
        invoiceList.add(item);
    }

    @Override
    public void update(int index, Invoice item) {
        if (index >= 0 && index < invoiceList.size()) {
            invoiceList.set(index, item);
            System.out.println("Cập nhật thành công!");
        } else {
            System.out.println("Vị trí không hợp lệ!");
        }
    }

    @Override
    public void delete(int index) {
        if (index >= 0 && index < invoiceList.size()) {
            invoiceList.remove(index);
            System.out.println("Xóa thành công!");
        } else {
            System.out.println("Vị trí không hợp lệ!");
        }
    }

    @Override
    public void display() {
        if (invoiceList.isEmpty()) {
            System.out.println("Danh sách hóa đơn trống.");
        } else {
            for (Invoice invoice : invoiceList) {
                System.out.println(invoice);
            }
        }
    }

    public int findIndexById(String id) {
        for (int i = 0; i < invoiceList.size(); i++) {
            if (invoiceList.get(i).getId().equalsIgnoreCase(id.trim())) {
                return i;
            }
        }
        return -1;
    }
}