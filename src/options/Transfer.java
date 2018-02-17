package options;

import atmException.ATMException;
import atmException.UnsuficientBalance;

import java.util.Scanner;

public class Transfer implements Transaction {

    private final TransactionType type = TransactionType.TRANSFERENCIA;
    private final Scanner scanner = new Scanner(System.in);
    private final BankSystem bank;
    private double value;

    public Transfer(BankSystem bank) {
        this.bank = bank;
    }

    @Override
    public void executeTransaction(Account account) throws ATMException {
        try {
            Account accountSecundaria = bank.verifyAccount(scanner.next());
            value = scanner.nextDouble();
            account.retirarDinheiro(value);
            accountSecundaria.deposit(value);
        } catch (UnsuficientBalance e) {
            throw new UnsuficientBalance("Falha na transferência: " + e.getMessage(), e);
        }
    }

    @Override
    public TransactionType getType() {
        return type;
    }

    @Override
    public double getValue() {
        return value;
    }
}
