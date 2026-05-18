package SS12_Bai2;

public class NetworkDevice extends Asset {
    private int numberOfPorts;

    public NetworkDevice(String assetCode, String name, double purchasePrice, int numberOfPorts) {
        super(assetCode, name, purchasePrice);
        this.numberOfPorts = numberOfPorts;
    }

    @Override
    public double getMarketValue() {
        return purchasePrice * 0.9;
    }

    @Override
    public String toString() {
        return String.format("Thiết bị mạng - Mã: %s | Tên: %s | Số cổng: %d | Giá gốc: %,.0f VNĐ",
                assetCode, name, numberOfPorts, purchasePrice);
    }
}