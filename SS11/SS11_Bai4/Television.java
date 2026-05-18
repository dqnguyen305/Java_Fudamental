package SS11_Bai4;

public class Television extends Device implements Connectable{
    public Television(int id, String name) {
        super(id, name);
    }
    @Override
    public void turnOn() {
        System.out.println("Turning on the television...");
    }
    @Override
    public void turnOff() {
        System.out.println("Turning off the television...");
    }
    @Override
    public void connectWifi() {
        System.out.println("Connecting the television to Wi-Fi...");
    }
}
