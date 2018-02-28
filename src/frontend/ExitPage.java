package frontend;

import atm.Account;

public class ExitPage implements Option {
    @Override
    public void run(Account account) {
        System.out.println("Bye");
        System.exit(0);
    }
}
