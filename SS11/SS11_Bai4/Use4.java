package SS11_Bai4;

public class Use4 {
    public static void main(String[] args) {
        Device d1 = new SmartPhone(1, "iPhone 12");
        Device d2 = new Laptop(2, "MacBook Pro");
        Device d3 = new Television(3, "iPad Air");

        Device[] list = {d1,d2,d3};

        for (Device d : list) {
            d.turnOn();
            if (d instanceof Connectable) {
                ((Connectable) d).connectWifi();
            }
            if (d instanceof Chargeable) {
                ((Chargeable) d).charge();
            }
            d.turnOff();
        }
    }
}
