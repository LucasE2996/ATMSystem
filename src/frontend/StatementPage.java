package frontend;

import FakeDB.DataBase;
import atm.Account;
import atm.options.Transaction;
import atm.options.TransactionType;

public class StatementPage implements Option {
    @Override
    public void run(Account account, DataBase db) {
        System.out.println("Seu historico:");
        for (Transaction transaction:
                account.getTrackingService().getTransactions()) {
            if(transaction.getType().equals(TransactionType.SAQUE)){
                System.out.println("Saque no valor de: " + transaction.getValue());
            } else if (transaction.getType().equals(TransactionType.DEPOSITO)){
                System.out.println("Deposito no valor de: " + transaction.getValue());
            } else if (transaction.getType().equals(TransactionType.TRANSFERENCIA)) {
                System.out.println("Transferencia no valor de " + transaction.getValue() +
                " para " + transaction.get);
            }
        }
    }
}
