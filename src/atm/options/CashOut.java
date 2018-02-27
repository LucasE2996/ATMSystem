package atm.options;

import atm.Account;

public class CashOut extends Transaction {

    public CashOut() {
        super(TransactionType.SAQUE);
    }

    public void execute(Account account, double value) {
        setClientName(account.getClientName());
        setValue(value * -1);
        account.getTrackingService().registerTransaction(this);
    }
}
