package frontend;

import atm.Account;
import atm.options.Transaction;
import atm.options.TransactionType;
import atm.options.Transfer;

public class StatementPage implements Option {
    @Override
    public void run(Account account) {
        System.out.println("Seu historico:");
        for (Transaction transaction:
                account.getTrackingService().getTransactions()) {
            if(transaction.getType().equals(TransactionType.SAQUE)){
                System.out.println("Saque no valor de: " + transaction.getValue());
            } else if (transaction.getType().equals(TransactionType.DEPOSITO)){
                System.out.println("Deposito no valor de: " + transaction.getValue());
            } else if (transaction.getType().equals(TransactionType.TRANSFERENCIA)) {
                Transfer transfer = (Transfer) transaction;
                System.out.println("Transferencia no valor de " + transaction.getValue() +
                " para " + transfer.getDestinyAccountName());
            }
        }
    }
}
