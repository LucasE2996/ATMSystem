package options;

import atmException.ATMException;
import atmException.UnsuficientBalance;

import java.util.Scanner;

public class Transfer extends CashOut {

    private final Scanner scanner = new Scanner(System.in);

    public Transfer(TransactionType type) {
        super(type);
    }

    @Override
    public void execute(TrackingService trackingService) throws ATMException {
        value = scanner.nextDouble() * -1;
        trackingService.registerTransaction(this);
    }
}
