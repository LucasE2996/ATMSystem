package options;

import atmException.ATMException;

import java.util.Scanner;

public class CashOut implements Transaction {
    // all values here are negative
    private double value;
    private final Scanner scanner = new Scanner(System.in);
    private final TransactionType type = TransactionType.SAQUE;

    @Override
    public void execute(TrackingService trackingService) throws ATMException {
        value = scanner.nextDouble() * -1;
    }

    public TransactionType getType() {
        return type;
    }

    @Override
    public double getValue() {
        return value;
    }
}
