package practice;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class DepositAccount extends BankAccount {
    private LocalDate lastIncome;
    DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

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
        lastIncome = LocalDate.now();
    }

    @Override
    public void take(double amountToTake) {
        if (ChronoUnit.MONTHS.between(lastIncome, LocalDate.now()) >= 1) {
            super.take(amountToTake);
        } else {
            System.out.println("Запрет выполнения операции списания. С даты последнего пополнения "
                    + dateFormatter.format(lastIncome) + " прошло менее одного месяца.");
        }
    }
}
