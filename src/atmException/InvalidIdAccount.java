package atmException;

public class InvalidIdAccount extends ATMException {

    // Constructor that accepts a message and the cause
    public InvalidIdAccount(String message, ATMException cause) {
        super("Account inválida", cause);
    }

    // Constructor that accepts just the cause
    public InvalidIdAccount(ATMException cause) {
        super(cause);
    }
}
