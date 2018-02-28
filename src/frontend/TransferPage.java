package frontend;

import FakeDB.DataBase;
import atm.Account;
import atm.options.Transfer;

import java.util.Scanner;

public class TransferPage implements Option {

    private final Scanner scanner;
    private final DataBase db;

    public TransferPage(Scanner scanner, DataBase db) {
        this.scanner = scanner;
        this.db = db;
    }

    @Override
    public void run(Account account) {
        System.out.println("Digite a conta destino: ");
        Account destinyAccount = db.getAccountByNumber(scanner.next());

        System.out.println("Digite o valor:");
        Transfer transfer = new Transfer();
        try{
            transfer.execute(account, scanner.nextDouble(), destinyAccount);
        } catch (RuntimeException e) {
            e.printStackTrace();
        }
    }
}
