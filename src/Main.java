import controller.Controller;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);
        Controller controller = new Controller();

        System.out.println("Bem vindo ao Banco CHEI LONG\n\n");

        controller.logar();

        while (true) {
            controller.options();
            controller.executarOpcao(scanner.nextInt());
        }
    }
}
