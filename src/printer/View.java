package printer;

import FakeDB.DataBase;
import atm.ATM;
import atm.Account;
import atm.options.TrackingService;

import java.util.Scanner;

public class View {

    private final Scanner scanner = new Scanner(System.in);
    private final DataBase db;
    private final TrackingService trackingService;
    private final ATM atm;
    private Account loggedUser;

    public View() {
        db = new DataBase();
        trackingService = new TrackingService();
        atm = new ATM();
        initializeDB();
    }

    private void initializeDB() {
        db.addAccount(new Account("54125-9", "João da Silva"));
        db.addAccount(new Account("25214-8", "Pedro Otávio Magalhães"));
        db.addAccount(new Account("88452-1", "Maria Green"));
        db.addAccount(new Account("15935-7", "Stephan Pereira"));
    }

    public void mainRoutine() {
        askForAccount();
        showOptions();

    }

    public void showOptions() {
        System.out.println("------------------\n" +
                "Operações:\n1- Saldo\n2- Saque\n3- Depósito\n4- Transferência\n5- Statement\n6- Sair\n" +
                "------------------\n" +
                "Digite o número da operação:");
        atm.executeOption(scanner.nextInt(), loggedUser);
    }

    public void askForAccount() {
        System.out.println("Entre com a conta:");
        loggedUser = db.getAccountByName(scanner.next());
    }

    public void printOption(int option) {
        switch (option) {
            case 1:
                System.out.printf("Seu saldo é de: ");
                break;
            case 2:
                System.out.printf("Digite o valor: ");
                break;
            case 3:
                System.out.print("Digite o valor: ");
                break;
            case 4:
                System.out.println("Digite a conta destino, em seguida o valor: ");
                break;
            case 6:
                System.out.println("Saindo....");
        }
    }

}
