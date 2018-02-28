package frontend;

import atm.Account;

public class BalancePage implements Option {

    @Override
    public void run(Account account) {
        System.out.println("Seu saldo é  de:");
        System.out.println(account.getTrackingService().calcBalance());
    }
}
