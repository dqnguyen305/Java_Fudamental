public class SS8_CurrencyConverter {
    private static double er = 0;

    public static void setRate(double r) {
        if (r <= 0) {
            System.out.println("Lỗi: Tỷ giá phải lớn hơn 0.");
        } else {
            er = r;
            System.out.println("Tỷ giá đã được cập nhật: " + er);
        }
    }

    public static double getRate(){
        return er;
    }

    public static double convertToUSD(int vnd) {
        if (er <= 0) {
            System.out.println("Lỗi: Tỷ giá chưa được thiết lập.");
            return 0;
        }
        return (double)vnd / er;
    }

    public static String formatUSD(double usd){
        return String.format("$%.2f", usd);
    }
    public static void main(String[] args) {
        setRate(23000);
        int amountVND = 460000;
        double amountUSD = convertToUSD(amountVND);
        System.out.println("Số tiền " + amountVND + " VND tương đương với " + formatUSD(amountUSD));
    }

}
