package atm;

import java.util.NoSuchElementException;

public class Login {

    public Account verifyAccount(String accountNumber) {
        return accounts.stream()
                .filter(account -> account.exists(accountNumber))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }
}
