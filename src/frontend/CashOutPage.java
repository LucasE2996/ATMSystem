package frontend;

import atm.Account;
import atm.options.CashOut;

import java.util.Scanner;

public class CashOutPage implements Option {

    private final Scanner scanner;

    public CashOutPage(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public void run(Account account) {
        System.out.println("Digite o valor: ");
        CashOut cashOut = new CashOut();
        try{
            cashOut.execute(account, scanner.nextDouble());
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
