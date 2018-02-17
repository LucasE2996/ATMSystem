package atmException;

public class DepositException extends ATMException {

    // Constructor that accepts a message
    public DepositException(String message) {
        super(message);
    }

    // Constructor that accepts a message and the cause
    public DepositException(String message, Exception cause) {
        super(message, cause);
    }

    // Constructor that accepts just the cause
    public DepositException(Exception cause) {
        super(cause);
    }
}
