package atm.options;

import java.util.concurrent.atomic.AtomicReference;

public class ShowSaldo {

    public Float execute(TrackingService trackingService) {
        AtomicReference<Float> saldo = new AtomicReference<>((float) 0);
        trackingService.getTransactions()
                .forEach(transaction -> saldo.updateAndGet(v -> new Float((float) (v + transaction.getValue()))));
        return saldo.get();
    }
}
