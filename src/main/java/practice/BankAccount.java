package practice;

public class BankAccount {
    public double amount;
    public boolean isProgress;

    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount();
        CardAccount cardAccount = new CardAccount();
        DepositAccount depositAccount = new DepositAccount();
        // cardAccount.setAmount(100);
        // cardAccount.send(depositAccount, 20);
    }

    // по-хорошему ещё нужна информация о типе счета, но тогда тесты не пропускают
    public double getAmount() {
        System.out.println("Текущий баланс на счете: " + amount);
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void put(double amountToPut) {
        if (amountToPut > 0) {
            amount += amountToPut;
            System.out.println("Баланс на счете после операции пополнения: " + amount);
        } else {
            System.out.println("Указана некорректная сумма пополнения.");
        }
    }

    public void take(double amountToTake) {
        if (amountToTake > 0) {
            if (getAmount() < amountToTake) {
                System.out.println("На счете недостаточно средств для списания.");
                isProgress = false;
            } else {
                amount -= amountToTake;
                isProgress = true;
                System.out.println("Баланс на счете после операции списания: " + amount);
            }
        } else {
            System.out.println("Указана некорректная сумма списания.");
        }
    }

    public boolean send(BankAccount receiver, double amount) {
        take(amount);
        if (isProgress) {
            receiver.put(amount);
            return true;
        } else {
            return false;
        }
    }
}
