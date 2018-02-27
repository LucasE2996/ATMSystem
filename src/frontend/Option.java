package frontend;

import FakeDB.DataBase;
import atm.Account;

public interface Option {
    void run(Account account, DataBase db);
}
