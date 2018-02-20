package atm;

import atmException.*;
import options.*;

public class ATM {
    private final BankSystem bank = new BankSystem();
    private final MoneyHandler moneyHandler = new MoneyHandler();
    private Account loggedAccount;
    private Account accountSecundaria;


    public ATM() {
        this.moneyHandler.setCelula100Pilha(4);
        this.moneyHandler.setCelula50Pilha(4);
        this.moneyHandler.setCelula20Pilha(10);
        this.moneyHandler.setCelula10Pilha(20);
    }

    public void executeOption(int optionNumb) throws ATMException {
        if (!(optionNumb > 5)) {
            Transaction transaction = (Transaction)bank.getTransaction(optionNumb+1);
            transaction.execute(loggedAccount);
            this.bank.addTransaction(transaction);

        } else {
            System.exit(0);
        }
    }

    public boolean logar(String accountNumber) {
        this.loggedAccount = this.bank.verifyAccount(accountNumber);
        return this.loggedAccount != null;
    }

    private void spareBills(double valor) throws OutOfBill {
        int nota100 = moneyHandler.divideBills((byte)100, this.moneyHandler.getCelula100Pilha(), valor);
        valor -= nota100*100;
        int nota50 = moneyHandler.divideBills((byte)50, this.moneyHandler.getCelula50Pilha(), valor);
        valor -= nota50*50;
        int nota20 = moneyHandler.divideBills((byte)20, this.moneyHandler.getCelula20Pilha(), valor);
        valor -= nota20*20;
        int nota10 = moneyHandler.divideBills((byte)10, this.moneyHandler.getCelula10Pilha(), valor);
        valor -= nota10*10;

        System.out.println("Notas de R$ 100,00: " + nota100);
        System.out.println("Notas de R$ 50,00: " + nota50);
        System.out.println("Notas de R$ 20,00: " + nota20);
        System.out.println("Notas de R$ 10,00: " + nota10);
        System.out.println("Valor não pode ser sacado: " + valor);
    }

}
