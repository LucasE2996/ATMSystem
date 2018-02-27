package frontend;

import FakeDB.DataBase;
import atm.ATM;
import atm.Account;
import atm.options.TrackingService;

import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class View {

    private final Scanner scanner = new Scanner(System.in);
    private final DataBase db;
    private final ATM atm;
    private Account loggedUser;
    private HashMap<Integer, Option> options = new HashMap<>();

    public View() {
        db = new DataBase();
        atm = new ATM();
        initializeDB();

        options.put(1, new BalancePage());
        options.put(2, new CashOutPage());
        options.put(3, new DepositPage());
        options.put(4, new TransferPage());
        options.put(5, new StatementPage());
        options.put(6, new ExitPage());
    }

    private void initializeDB() {
        db.addAccount(new Account("54125-9", "João da Silva", new TrackingService()));
        db.addAccount(new Account("25214-8", "Pedro Otávio Magalhães", new TrackingService()));
        db.addAccount(new Account("88452-1", "Maria Green", new TrackingService()));
        db.addAccount(new Account("15935-7", "Stephan Pereira", new TrackingService()));
    }

    public void mainRoutine() {
        askForAccount();
        while (true) {
            showOptions();
        }
    }

    private void askForAccount() {
        System.out.println("Entre com a conta:");
        loggedUser = db.getAccountByName(scanner.next());
    }

    private void showOptions() {
        System.out.println("------------------\n" +
                "Operações:\n1- Saldo\n2- Saque\n3- Depósito\n4- Transferência\n5- Statement\n6- Sair\n" +
                "------------------\n" +
                "Digite o número da operação:");
        executeOption(scanner.nextInt());
    }

    private void executeOption(int num) {
        options.entrySet().stream()
                .filter(entry -> entry.getKey() == num)
                .findAny()
                .orElseThrow(NoSuchElementException::new)
                .getValue()
                .run(loggedUser, db);
    }

}
