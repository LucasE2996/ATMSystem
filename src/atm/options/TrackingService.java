package atm.options;

import java.util.LinkedList;

public class TrackingService {

    private LinkedList<Transaction> transactions = new LinkedList<>();

    public void registerTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public LinkedList<Transaction> getTransactions() {
        return transactions;
    }
}
