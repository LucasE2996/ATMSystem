package atmException;

public class UnsuficientBalance extends ATMException {

    // Constructor that accepts a message
    public UnsuficientBalance(String message) {
        super(message);
    }

    // Constructor that accepts a message and the cause
    public UnsuficientBalance(String message, Exception cause) {
        super(message, cause);
    }

    // Constructor that accepts just the cause
    public UnsuficientBalance(Exception cause) {
        super(cause);
    }
}
