package atm.options;

import atm.Account;

public class Transfer extends Transaction {

    private String destinyAccountName;

    public Transfer() {
        super(TransactionType.TRANSFERENCIA);
    }

    public void execute(Account account, double value, Account destinyAccount) {
        setClientName(account.getClientName());
        setValue(value * -1);
        this.destinyAccountName = destinyAccount.getClientName();
        account.getTrackingService().registerTransaction(this);
        setValue(value);
        destinyAccount.getTrackingService().registerTransaction(this);
    }

    public String getDestinyAccountName() {
        return destinyAccountName;
    }
}
