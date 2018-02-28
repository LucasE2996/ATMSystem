package atm.options;

import atm.Account;

public class Transfer extends Transaction {

    private String destinyAccountName;

    public Transfer() {
        super(TransactionType.TRANSFERENCIA);
    }

    public void execute(Account account, double value, Account destinyAccount) throws RuntimeException{
        if(account.getNumero().equals(destinyAccount.getNumero())) {
            throw new RuntimeException("Operacao nao permitida");
        } else {
            setClientName(account.getClientName());
            setValue(value * -1);
            this.destinyAccountName = destinyAccount.getClientName();
            account.getTrackingService().registerTransaction(this);
            Transfer transfer = new Transfer();
            transfer.setClientName(this.destinyAccountName);
            transfer.setValue(value);
            transfer.destinyAccountName = account.getClientName();
            destinyAccount.getTrackingService().registerTransaction(transfer);
        }
    }

    public String getDestinyAccountName() {
        return destinyAccountName;
    }
}
