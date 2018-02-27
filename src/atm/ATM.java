package atm;

import atm.options.CashOut;
import atm.options.Deposit;
import atm.options.Executable;
import atm.options.Transfer;

import java.util.HashMap;
import java.util.NoSuchElementException;

public class ATM {
    private final MoneyHandler moneyHandler = new MoneyHandler();
    private HashMap<Integer, Executable> executables = new HashMap<>();

    public ATM() {
        this.moneyHandler.setCelula100Pilha(4);
        this.moneyHandler.setCelula50Pilha(4);
        this.moneyHandler.setCelula20Pilha(10);
        this.moneyHandler.setCelula10Pilha(20);
        this.executables.put(1, new CashOut());
        this.executables.put(2, new Deposit());
        this.executables.put(3, new Transfer());
    }

    public void executeOption(int num, Account loggedAccount) {
        executables.entrySet().stream()
                .filter(entry -> entry.getKey() == num)
                .findAny()
                .orElseThrow(NoSuchElementException::new)
                .getValue().exe
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
