package practice;

public class CardAccount extends BankAccount {
    private static final double PERCENT_COMMISSIONS = 0.01;

    @Override
    public double getAmount() {
        return super.getAmount();
    }

    @Override
    public void setAmount(double amount) {
        super.setAmount(amount);
    }

    @Override
    public void put(double amountToPut) {
        super.put(amountToPut);
    }

    @Override
    public void take(double amountToTake) {
        amountToTake += (amountToTake * PERCENT_COMMISSIONS);
        super.take(amountToTake);
    }
}
