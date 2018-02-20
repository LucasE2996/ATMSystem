package options;

import atmException.ATMException;
import atmException.DepositException;

import java.util.Scanner;

public class Deposit extends Transaction {

    Scanner scanner = new Scanner(System.in);

    public Deposit(TransactionType type) {
        super(type);
    }

    @Override
    public void execute(TrackingService trackingService) {
       value = this.scanner.nextDouble();
       trackingService.registerTransaction(this);
    }

}
