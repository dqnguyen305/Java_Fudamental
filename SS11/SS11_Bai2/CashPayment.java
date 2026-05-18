package SS11_Bai2;

public class CashPayment extends Payment{
    @Override
    public void pay() {
        System.out.println("Paying " + amount + " in cash.");
    }
}
