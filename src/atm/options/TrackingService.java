package atm.options;

import java.util.Collections;
import java.util.LinkedList;

public class TrackingService {

    private LinkedList<Transaction> transactions;

    public TrackingService() {
        transactions  = new LinkedList<>();
    }

    public void registerTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public LinkedList<Transaction> getTransactions() {
        return transactions;
    }

    public double calcBalance() {
        return transactions.stream().mapToDouble(Transaction::getValue).sum();
    }
}
