package options;

import atmException.ATMException;

import java.util.Scanner;

public class CashOut extends Transaction {
    // all values here are negative
    private final Scanner scanner = new Scanner(System.in);

    public CashOut(TransactionType type) {
        super(type);
    }

    @Override
    public void execute(TrackingService trackingService) throws ATMException {
        value = scanner.nextDouble() * -1;
        trackingService.registerTransaction(this);
    }

}
