package SS11_Bai4;

abstract class Device {
    protected int id;
    protected String name;

    public Device(int id, String name) {
        this.id = id;
        this.name = name;
    }
    abstract void turnOn();
    abstract void turnOff();

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
}
