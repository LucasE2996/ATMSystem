package frontend;

import FakeDB.DataBase;
import atm.Account;
import atm.options.Transfer;

import java.util.Scanner;

public class TransferPage implements Option {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void run(Account account, DataBase db) {
        System.out.println("Digite a conta destino: ");
        Account destinyAccount = db.getAccountByName(scanner.next());
        System.out.println("Digite o valor:");
        Transfer transfer = new Transfer();
        transfer.execute(account, scanner.nextDouble(), destinyAccount);
    }
}
