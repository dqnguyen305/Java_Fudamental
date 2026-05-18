package SS11_Bai4;

public class Laptop extends Device implements Connectable, Chargeable {
    public Laptop(int id, String name) {
        super(id, name);
    }
    @Override
    public void turnOn() {
        System.out.println("Turning on the laptop...");
    }
    @Override
    public void turnOff() {
        System.out.println("Turning off the laptop...");
    }
    @Override
    public void connectWifi() {
        System.out.println("Connecting to Wi-Fi...");
    }

    @Override
    public void charge() {
        System.out.println("Charging the laptop...");
    }
}
