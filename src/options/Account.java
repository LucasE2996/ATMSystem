package options;

import atmException.UnsuficientBalance;

public class Account {

   private final String numero;
   private final String clientName;
   private double accoutvalue;

   public Account(String numero, String cliente, double accoutvalue) {
        this.numero = numero;
        this.clientName = cliente;
        this.accoutvalue = accoutvalue;
    }

   protected double getSaldo() {
       return this.accoutvalue;
    }

   protected void retirarDinheiro(double valor) throws UnsuficientBalance {
        if (valor < this.getSaldo()) {
            this.accoutvalue -= valor;
        } else {
            throw new UnsuficientBalance("Saldo insuficiente");
        }
   }

   protected void deposit(double valor) {
       this.accoutvalue += valor;
   }

   public boolean exists(String number) {
       return this.numero.equals(number);
   }
}
