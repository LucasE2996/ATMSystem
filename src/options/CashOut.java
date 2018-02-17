package options;

import atmException.ATMException;
import atmException.UnsuficientBalance;
import java.util.Scanner;

public class CashOut implements Transaction {

    private double value;
    private final Scanner scanner = new Scanner(System.in);
    private final TransactionType type = TransactionType.SAQUE;

    public void executeTransaction(Account account) throws ATMException {
        try {
            value = scanner.nextDouble();
            account.retirarDinheiro(value);
        } catch (UnsuficientBalance e) {
            throw new UnsuficientBalance("Saldo Insuficiente", e);
        }
    }

    public TransactionType getType() {
        return type;
    }

    @Override
    public double getValue() {
        return value;
    }
}
