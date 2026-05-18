package SS11_Bai4;

public class SmartPhone extends Device implements Connectable, Chargeable {
    public SmartPhone(int id, String name) {
        super(id, name);
    }
    @Override
    public void turnOn() {
        System.out.println("Turning on the smartphone...");
    }
    @Override
    public void turnOff() {
        System.out.println("Turning off the smartphone...");
    }
    @Override
    public void connectWifi() {
        System.out.println("Connecting to Wi-Fi...");
    }

    @Override
    public void charge() {
        System.out.println("Charging the smartphone...");
    }
}
