package atm.options;

import atm.Account;

public class CashOut extends Transaction implements Executable {

    public CashOut() {
        super(TransactionType.SAQUE);
    }

    @Override
    public void execute(TrackingService trackingService, Account account, double value) {
        setClientName(account.getClientName());
        setValue(value * -1);
        trackingService.registerTransaction(this);
    }
}
