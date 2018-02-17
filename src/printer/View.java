package printer;

import java.util.Scanner;

public class View {

    final private Scanner scanner;

    public View() {
        this.scanner = new Scanner(System.in);
    }

    public void showOptions() {
        System.out.println("------------------\n" +
                "Operações:\n1- Saldo\n2- Saque\n3- Depósito\n4- Transferência\n5- Statement\n6- Sair\n" +
                "------------------\n" +
                "Digite o número da operação:");
    }

    public void askForAccount() {
        System.out.println("Entre com a conta: ");
    }

    public String getInputValue() {
        return this.scanner.next();
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
