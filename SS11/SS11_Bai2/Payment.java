package SS11_Bai2;

abstract class Payment {
    protected double amount;

    abstract void pay();
    public void printAmount(){
        System.out.println("Amount: " + amount);
    }
}
