package atm.options;

import atmException.ATMException;

public abstract class Transaction {

    private final TransactionType type;
    double value;

    Transaction(TransactionType type) {
        this.type = type;
    }

    abstract void execute(TrackingService trackingService) throws ATMException;

    TransactionType getType() {
        return type;
    }

    double getValue() {
        return value;
    }
}
