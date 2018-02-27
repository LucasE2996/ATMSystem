package atm;

public class Account {

   private final String numero;
   private final String clientName;
   private Statement statement;

   public Account(String numero, String cliente) {
        this.numero = numero;
        this.clientName = cliente;
    }

   public boolean exists(String number) {
       return this.numero.equals(number);
   }

    public String getClientName() {
        return clientName;
    }

    public Statement getStatement() {
        return statement;
    }
}
