package SS14_Bai4.model;

public class PhoneError {
    private final String phoneNumber;
    private final String reason;

    public PhoneError(String phoneNumber, String reason) {
        this.phoneNumber = phoneNumber;
        this.reason = reason;
    }

    @Override
    public String toString() {
        return phoneNumber + " : " + reason;
    }
}