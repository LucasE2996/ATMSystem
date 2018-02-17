package options;

import atmException.ATMException;

public interface Transaction {

    void executeTransaction(Account account) throws ATMException;

    TransactionType getType();

    double getValue();
}
