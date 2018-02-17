package atm;

import options.Money;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;

public class MoneyHandlerTester {

    MoneyHandler moneyHandler = new MoneyHandler();
    MoneyHandlerWithList moneyHandlerWithList = new MoneyHandlerWithList();
    List cedulas = Arrays.asList(100, 50, 20, 10);

    @Test
    void setCelula() {
        moneyHandler.setCelula100Pilha(4);
        int expectedValue = 100;
        int outputValue = moneyHandler.getCelula100();
        Assertions.assertEquals(expectedValue, outputValue);
    }

    @Test
    void celulaSize() {
        moneyHandler.setCelula100Pilha(5);
        int expectedValue = 5;
        int outputValue = moneyHandler.getCelula100Pilha().size();

        Assertions.assertEquals(expectedValue, outputValue);
    }

    @Test
    void separacaoNota100() {
        moneyHandler.setCelula100Pilha(5);
        double value  = 590;
        int expectedValue = 5;
        int outputValue = (int)value/ moneyHandler.getCelula100();

        Assertions.assertEquals(expectedValue, outputValue);
    }

    @Test
    void sacar() {
        moneyHandler.setCelula100Pilha(3);
        moneyHandler.setCelula50Pilha(0);
        moneyHandler.setCelula20Pilha(0);
        moneyHandler.setCelula10Pilha(0);
        double valor = 250;
        int valorRetirado = 0;
        int nota100 = 0;
        int nota50 = 0;
        int nota20 = 0;
        int nota10 = 0;
        final int pilha100Size = moneyHandler.getCelula100Pilha().size();
        final int pilha50Size = moneyHandler.getCelula50Pilha().size();
        final int pilha20Size = moneyHandler.getCelula20Pilha().size();
        final int pilha10Size = moneyHandler.getCelula10Pilha().size();

        for (int i = 0; i<pilha100Size; i++) {
            if (valor > 0 && valor >= 100) {
                nota100++;
                valorRetirado += 100;
                valor-= moneyHandler.getCelula100();
            }
        }
        for (int i = 0; i<pilha50Size; i++) {
            if (valor > 0 && valor >= 50) {
                nota50++;
                valorRetirado += 50;
                valor-= moneyHandler.getCelula50();
            }
        }
        for (int i = 0; i<pilha20Size; i++) {
            if (valor > 0 && valor >= 20) {
                nota20++;
                valorRetirado += 20;
                valor-= moneyHandler.getCelula20();
            }
        }
        for (int i = 0; i<pilha10Size; i++) {
            if (valor > 0 && valor >= 10) {
                nota10++;
                valorRetirado += 10;
                valor-= moneyHandler.getCelula10();
            }
        }

        if (valor != valorRetirado) {
            if(valor < 10) {
                System.out.println("Sobrou " + valor);
            }else {
                System.out.println("Algo deu errado!");
            }
        }


        int expectedOutput = 0;
        int output = nota100;

//        Assertions.assertEquals(expectedOutput, output);
    }

    @Test
    void sacarComList() {
        this.moneyHandlerWithList.setCedulasList(new Money((byte)100),3);
        this.moneyHandlerWithList.setCedulasList(new Money((byte)50),0);
        this.moneyHandlerWithList.setCedulasList(new Money((byte)20),0);
        this.moneyHandlerWithList.setCedulasList(new Money((byte)10),0);

        double valor = 250;
        int valorRetirado = 0;
        int nota100 = 0;
        int nota50 = 0;
        int nota20 = 0;
        int nota10 = 0;

        if (moneyHandlerWithList.getTotalValue() > valor) {

            for (int i=0; i<cedulas.size(); i++) {
                int type = (int) cedulas.get(i);
                valorRetirado += this.getNota(type,valor);
                valor -= valorRetirado;
            }

        } else {
            System.out.println("Saldo de caixa insuficiente");
        }

        if (valor > 0) {
            if (valor < 10) {
                System.out.println("Sobrou: R$" + valor);
            } else {
                System.out.println("Algo deu errado");
            }

        }

        System.out.println("Valor Retirado: " + valorRetirado);
    }

    @Test
    void popWith1Value() {
        moneyHandler.setCelula100Pilha(1);
        moneyHandler.getCelula100();
    }

    private double getNota(int type, double valor) {
        double valorRetirado = 0;
        try {
            while (valor >= type) {
                moneyHandlerWithList.getCedula((byte)type);
                valor -= type;
                valorRetirado += type;
            }
        } catch (NoSuchElementException e) {
            System.out.println();
        }
        return valorRetirado;
    }
}
