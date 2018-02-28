package atm.options;

import atm.Account;

public class CashOut extends Transaction {

    public CashOut() {
        super(TransactionType.SAQUE);
    }

    public void execute(Account account, double value) throws RuntimeException {
        if(account.getTrackingService().calcBalance() < value) {
            throw new RuntimeException("Saldo insuficiente");
        } else {
            setClientName(account.getClientName());
            setValue(value * -1);
            account.getTrackingService().registerTransaction(this);
        }
    }
}
