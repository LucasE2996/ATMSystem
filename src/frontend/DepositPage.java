package frontend;

import atm.Account;
import atm.options.Deposit;

import java.util.Scanner;

public class DepositPage implements Option {

    private final Scanner scanner;

    public DepositPage(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void run(Account account) {
        System.out.println("Digite o valor:");
        Deposit deposit = new Deposit();
        deposit.execute(account, scanner.nextDouble());
    }
}
