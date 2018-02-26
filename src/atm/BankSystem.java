package atm;

import atm.options.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class BankSystem {

    private final TrackingService trackingService = new TrackingService();
    private ArrayList<Object> transactions = new ArrayList<>();

    public BankSystem() {
        this.transactions.add(new ShowSaldo());
        this.transactions.add(new CashOut(TransactionType.SAQUE));
        this.transactions.add(new Deposit(TransactionType.DEPOSITO));
        this.transactions.add(new Transfer(TransactionType.TRANSFERENCIA));
        this.transactions.add(new Statement(this.trackingService));

        this.accounts = Arrays.asList(

        );
    }

    public Object getTransaction(int position) {
        return this.transactions.get(position);
    }



    public void addTransaction(Transaction transaction) {
        this.trackingService.registerTransaction(transaction);
    }
}
