package atm;

import atmException.OutOfBill;

import java.util.Stack;

public class MoneyHandler {

    private Stack<Money> Celula100Pilha = new Stack<>();
    private Stack<Money> Celula50Pilha = new Stack<>();
    private Stack<Money> Celula20Pilha = new Stack<>();
    private Stack<Money> Celula10Pilha = new Stack<>();


    public int getCelula100() {
        final double value = this.Celula100Pilha.peek().getValue();
        this.Celula100Pilha.pop();
        return (int) value;
    }

    public int getCelula50() {
        final double value = this.Celula50Pilha.peek().getValue();
        this.Celula50Pilha.pop();
        return (int) value;
    }

    public int getCelula20() {
        final double value = this.Celula20Pilha.peek().getValue();
        this.Celula20Pilha.pop();
        return (int) value;
    }

    public int getCelula10() {
        final double value = this.Celula10Pilha.peek().getValue();
        this.Celula10Pilha.pop();
        return (int) value;
    }

    public Stack<Money> getCelula100Pilha() {
        return Celula100Pilha;
    }

    public Stack<Money> getCelula50Pilha() {
        return Celula50Pilha;
    }

    public Stack<Money> getCelula20Pilha() {
        return Celula20Pilha;
    }

    public Stack<Money> getCelula10Pilha() {
        return Celula10Pilha;
    }

    public void setCelula100Pilha(int qtd) {
        for(int i=0; i<qtd; i++) {
            Celula100Pilha.push(new Money((byte)100));
        }
    }

    public void setCelula50Pilha(int qtd) {
        for(int i=0; i<qtd; i++) {
            Celula50Pilha.push(new Money((byte)50));
        }
    }

    public void setCelula20Pilha(int qtd) {
        for(int i=0; i<qtd; i++) {
            Celula20Pilha.push(new Money((byte)20));
        }
    }

    public void setCelula10Pilha(int qtd) {
        for(int i=0; i<qtd; i++) {
            Celula10Pilha.push(new Money((byte)10));
        }
    }

    protected int divideBills(byte value, Stack<Money> type, double valorTotal) throws OutOfBill {
        int qtd = 0;
        int pilhaSize = type.size();
        for (int i = 0; i<pilhaSize; i++) {
            if (valorTotal > 0 && valorTotal >= value) {
                qtd++;
                valorTotal-=value;
            }
        }
        return qtd;
    }
}
