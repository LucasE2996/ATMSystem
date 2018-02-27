package atm.options;

import atm.Account;

public class Transfer extends Transaction {

    private String destinyAccountName;

    public Transfer() {
        super(TransactionType.TRANSFERENCIA);
    }


    public void execute(TrackingService trackingService, Account account, double value, Account destinyAccountName) {
        setClientName(account.getClientName());
        setValue(value * -1);
        this.destinyAccountName = destinyAccountName.getClientName();
        trackingService.registerTransaction(this);
    }

    public String getDestinyAccountName() {
        return destinyAccountName;
    }
}
