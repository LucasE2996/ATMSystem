package frontend;

import FakeDB.DataBase;
import atm.Account;

public class ExitPage implements Option {
    @Override
    public void run(Account account, DataBase db) {
        System.out.println("Bye");
        System.exit(0);
    }
}
