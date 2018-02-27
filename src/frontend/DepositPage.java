package frontend;

import FakeDB.DataBase;
import atm.Account;
import atm.options.Deposit;

import java.util.Scanner;

public class DepositPage implements Option {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run(Account account, DataBase db) {
        System.out.println("Digite o valor:");
        Deposit deposit = new Deposit();
        deposit.execute(account, scanner.nextDouble());
    }
}
