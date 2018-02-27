package atm.options;

import atm.Account;

public class Deposit extends Transaction implements Executable {

    public Deposit() {
        super(TransactionType.DEPOSITO);
    }

    @Override
    public void execute(TrackingService trackingService, Account account, double value) {
        setClientName(account.getClientName());
        setValue(value);
        trackingService.registerTransaction(this);
    }
}
