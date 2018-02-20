package options;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReference;

public class BankSystem {

    private final TrackingService trackingService = new TrackingService();
    private ArrayList<Object> transactions = new ArrayList<>();
    private List<Account> accounts;

    public BankSystem() {
        this.transactions.add(new ShowSaldo());
        this.transactions.add(new CashOut());
        this.transactions.add(new Deposit());
        this.transactions.add(new Transfer(this));
        this.transactions.add(new Statement(this.trackingService));

        this.accounts = Arrays.asList(
                new Account("54125-9", "João da Silva"),
                new Account("25214-8", "Pedro Otávio Magalhães"),
                new Account("88452-1", "Maria Green"),
                new Account("15935-7", "Stephan Pereira")
        );
    }

    public Object getTransaction(int position) {
        return this.transactions.get(position);
    }

    public Account verifyAccount(String accountNumber) {
        return accounts.stream()
                .filter(account -> account.exists(accountNumber))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public void addTransaction(Transaction transaction) {
        this.trackingService.registerTransaction(transaction);
    }
}
