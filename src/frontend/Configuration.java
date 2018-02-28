package frontend;

import FakeDB.DataBase;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Configuration {
    private Map<Integer, Option> options = new HashMap<>();

    public Configuration(Scanner scanner, DataBase db) {
        options.put(1, new BalancePage());
        options.put(2, new CashOutPage(scanner));
        options.put(3, new DepositPage(scanner));
        options.put(4, new TransferPage(scanner, db));
        options.put(5, new StatementPage());
        options.put(6, new ExitPage());
    }

    public Map<Integer, Option> getOptions() {
        return options;
    }
}
