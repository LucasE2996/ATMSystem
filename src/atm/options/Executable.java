package atm.options;

import atm.Account;

public interface Executable {
    void execute(TrackingService trackingService, Account account, double value);
}
