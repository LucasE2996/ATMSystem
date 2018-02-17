package atmException;

public abstract class ATMException extends Exception{

    // Constructor that accepts a message
    public ATMException(String message) {
        super(message);
    }

    // Constructor that accepts a message and the cause
    public ATMException(String message, Exception cause) {
        super(message, cause);
    }

    // Constructor that accepts just the cause
    public ATMException(Exception cause) {
        super(cause);
    }

}
