import frontend.View;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){

        try(Scanner scanner = new Scanner(System.in)) {
            View view = new View(scanner);
            view.mainRoutine();
        }
    }
}
