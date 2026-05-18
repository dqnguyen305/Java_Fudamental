package SS11_Bai2;

public class EWalletPayment extends Payment implements Refundable {
    @Override
    public void pay() {
        System.out.println("Paying " + amount + " with e-wallet.");
    }

    @Override
    public void refund() {
        System.out.println("Refunding " + amount + " to e-wallet.");
    }
}
