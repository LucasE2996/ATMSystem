package options;

import atmException.ATMException;

public interface Transaction<T> {

    void execute(TrackingService trackingService) throws ATMException;

    TransactionType getType();

    double getValue();
}
