package options;

import atmException.ATMException;
import atmException.DepositException;

import java.util.Scanner;

public class Deposit implements Transaction {

    private double value;
    private final TransactionType type = TransactionType.DEPÓSITO;
    Scanner scanner = new Scanner(System.in);

    public void executeTransaction(Account account) throws ATMException {
        try{
            value = this.scanner.nextDouble();
            account.deposit(value);
        } catch (Exception e) {
            throw new DepositException("Falha ao desposotisar", e);
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
