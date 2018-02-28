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

    public Account getAccountByNumber(String number) {
        return accounts.stream()
                .filter(account -> account.getNumero().equals(number))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
