package atm;

import options.Money;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class MoneyHandlerWithList {

    private ArrayList<Money> cedulasList;

    MoneyHandlerWithList() {
        cedulasList = new ArrayList<>();
    }

    private Money searchCedula(byte valor) {
        return this.cedulasList.stream()
                .filter(money -> money.getValue()==(valor))
                .findAny()
                .orElseThrow(NoSuchElementException::new);
    }

    void getCedula(byte valor) {
        this.cedulasList.remove(this.searchCedula(valor));
    }

    void setCedulasList(Money money, int qtd) {
        for (int i=0; i<qtd; i++){
            this.cedulasList.add(money);
        }
    }

    double getTotalValue() {
        double total = this.cedulasList.stream().mapToDouble(Money::getValue).sum();
        return total;
    }
}
