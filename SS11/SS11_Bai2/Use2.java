package SS11_Bai2;

public class Use2 {
    public static void main(String[] args) {
        Payment p1 = new CashPayment();
        p1.amount = 100.0;
        Payment p2 = new EWalletPayment();
        p2.amount = 200.0;
        Payment p3 = new CreditCardPayment();
        p3.amount = 300.0;

        Payment[] list = {p1,p2,p3};

        for (Payment p : list) {
            p.pay();
            p.printAmount();
            if (p instanceof Refundable) {
                ((Refundable) p).refund();
            }
        }
    }
}
