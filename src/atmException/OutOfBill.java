package atmException;

public class OutOfBill extends ATMException{

    // Constructor that accepts a message
    public OutOfBill(String message) {
        super(message);
    }

    // Constructor that accepts a message and the cause
    public OutOfBill(String message, Exception cause) {
        super(message, cause);
    }

    // Constructor that accepts just the cause
    public OutOfBill(Exception cause) {
        super(cause);
    }
}
