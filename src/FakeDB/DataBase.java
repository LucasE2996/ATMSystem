package FakeDB;

import atm.Account;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class DataBase {
    private List<Account> accounts = new ArrayList<>();

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account getAccountByName(String name) {
        return accounts.stream()
                .filter(account -> account.getClientName().equals(name))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
