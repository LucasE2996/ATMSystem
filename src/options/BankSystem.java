package options;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class BankSystem {

    private final TrackingService trackingService = new TrackingService();
    private ArrayList<Transaction> transactions = new ArrayList<>();
    private List<Account> accounts;

    public BankSystem() {
        this.transactions.add(new ShowSaldo());
        this.transactions.add(new CashOut());
        this.transactions.add(new Deposit());
        this.transactions.add(new Transfer(this));
        this.transactions.add(new Statement(this.trackingService));

        this.accounts = Arrays.asList(
                new Account("54125-9", "João da Silva", 10854.78),
                new Account("25214-8", "Pedro Otávio Magalhães", 1050.99),
                new Account("88452-1", "Maria Green", 7696.00),
                new Account("15935-7", "Stephan Pereira", 412.13)
        );
    }


    public Transaction getTransaction(int position) {
        return this.transactions.get(position);
    }

    public Account verifyAccount(String accountNumber) {
        return accounts.stream()
                .filter(account -> account.exists(accountNumber))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    public void addTransaction(Transaction transaction) {
        this.trackingService.registerEvent(transaction);
    }
}
