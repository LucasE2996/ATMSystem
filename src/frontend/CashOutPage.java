package frontend;

import FakeDB.DataBase;
import atm.Account;
import atm.options.CashOut;

import java.util.Scanner;

public class CashOutPage implements Option {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run(Account account, DataBase db) {
        System.out.println("Digite o valor: ");
        CashOut cashOut = new CashOut();
        cashOut.execute(account, scanner.nextDouble());
    }
}
