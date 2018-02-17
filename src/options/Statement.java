package options;

public class Statement implements Transaction {
    TrackingService trackingService;

    public Statement(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    public void executeTransaction(Account account) {
        trackingService.getEvents().forEach(transaction -> System.out.println(
                "Foi feita um(a)" + transaction.getType() +
                        " no valor de " + transaction.getValue()
        ));
    }

    @Override
    public TransactionType getType() {
        return null;
    }

    @Override
    public double getValue() {
        return 0;
    }


}
