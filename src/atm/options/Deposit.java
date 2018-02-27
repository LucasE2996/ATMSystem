package atm.options;

import atm.Account;

public class Deposit extends Transaction {

    public Deposit() {
        super(TransactionType.DEPOSITO);
    }

    public void execute(Account account, double value) {
        setClientName(account.getClientName());
        setValue(value);
        account.getTrackingService().registerTransaction(this);
    }
}
