package atm.options;

import atmException.ATMException;

import java.util.Scanner;

public class Transfer extends CashOut {

    Transfer(TransactionType type) {
        super(type);
    }

    @Override
    public void execute(TrackingService trackingService) throws ATMException {
        trackingService.registerTransaction(this);
    }
}
