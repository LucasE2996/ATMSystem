package atm.options;

public abstract class Transaction {

    private final TransactionType type;
    private double value;
    private String clientName;

    Transaction(TransactionType type) {
        this.type = type;
    }

    public TransactionType getType() {
        return type;
    }

    public String getClientName() {
        return clientName;
    }

    public double getValue() {
        return value;
    }

    void setClientName(String clientName) {
        this.clientName = clientName;
    }

    void setValue(double value) {
        this.value = value;
    }
}
