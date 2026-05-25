package SS14_Bai4.exception;

public class InvalidPhoneNumberLengthException extends Exception {
    public InvalidPhoneNumberLengthException(String message) {
        super(message);
    }

    public static void validate(String phone) throws InvalidPhoneNumberLengthException {
        if (phone.contains(" ")) {
            throw new InvalidPhoneNumberLengthException("Không được chứa khoảng trắng");
        }
        if (!phone.matches("[0-9]+")) {
            throw new InvalidPhoneNumberLengthException("Chứa ký tự không hợp lệ");
        }
        if (phone.length() != 10) {
            throw new InvalidPhoneNumberLengthException("Độ dài không hợp lệ (phải đúng 10 chữ số)");
        }
    }
}