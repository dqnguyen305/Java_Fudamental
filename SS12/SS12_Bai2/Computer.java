package SS12_Bai2;

public class Computer extends Asset {
    private int ram;
    private String cpu;

    public Computer(String assetCode, String name, double purchasePrice, int ram, String cpu) {
        super(assetCode, name, purchasePrice);
        this.ram = ram;
        this.cpu = cpu;
    }

    @Override
    public double getMarketValue() {
        return purchasePrice * 0.8;
    }

    @Override
    public String toString() {
        return String.format("Máy tính - Mã: %s | Tên: %s | RAM: %dGB | CPU: %s | Giá gốc: %,.0f VNĐ",
                assetCode, name, ram, cpu, purchasePrice);
    }
}