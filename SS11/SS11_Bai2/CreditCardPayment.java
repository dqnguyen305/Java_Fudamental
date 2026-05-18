package SS11_Bai2;

public class CreditCardPayment extends Payment implements Refundable {
    @Override
    public void pay() {
        System.out.println("Paying " + amount + " with credit card.");
    }

    @Override
    public void refund() {
        System.out.println("Refunding " + amount + " to credit card.");
    }
}
