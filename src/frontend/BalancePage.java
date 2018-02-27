package frontend;

import FakeDB.DataBase;
import atm.Account;

public class BalancePage implements Option {

    @Override
    public void run(Account account, DataBase db) {
        System.out.println("Seu saldo é  de:");
        System.out.println(account.getTrackingService().calcBalance());
    }
}
