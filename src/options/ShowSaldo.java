package options;

public class ShowSaldo implements Transaction {

    @Override
    public void executeTransaction(Account account) {
        System.out.println(account.getSaldo());
    }

    @Override
    public TransactionType getType() {
        return null;
    }

    @Override
    public double getValue() {
        return 0;
    }


}
